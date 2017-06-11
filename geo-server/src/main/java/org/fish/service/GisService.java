package org.fish.service;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import org.fish.dao.PolygonRepository;
import org.fish.dto.MarkerCoords;
import org.fish.gis.model.PlanetOsmPolygon;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ubu on 06.06.17.
 */
@Service
public class GisService {


    @Autowired
    PolygonRepository polygonRepository;

    private MathTransform transform;

    @PostConstruct
    public void init(){

        try {
            CoordinateReferenceSystem   targetCRS = CRS.decode("EPSG:4326");
            CoordinateReferenceSystem sourceCRS = CRS.decode("EPSG:3857");

            transform = CRS
                    .findMathTransform(sourceCRS, targetCRS, false);
        } catch (FactoryException e) {
            e.printStackTrace();
        }

    }



    public  List<MarkerCoords> findInterestingWays() {

        List<MarkerCoords> markers = new ArrayList<MarkerCoords>();

        List<PlanetOsmPolygon> planetOsmPolygon =
                (ArrayList<PlanetOsmPolygon>) polygonRepository.findInterestingWays();

        planetOsmPolygon.forEach(p -> {

            if(p.getTags()!=null && !p.getTags().isEmpty()) {
                Geometry geo = p.getWay();
                Geometry transformedPoint = null;
                try {
                    transformedPoint = JTS.transform(geo, transform);
                } catch (TransformException e) {
                    e.printStackTrace();
                }
                Point center = transformedPoint.getCentroid();
                MarkerCoords coord = new MarkerCoords( center.getX() , center.getY(), p.getTags() );

                markers.add(coord);

            }

        });


        return markers;
    }

}
