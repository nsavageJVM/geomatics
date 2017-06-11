package org.fish.dao;

import com.vividsolutions.jts.geom.*;

import org.fish.dto.MarkerCoords;

import org.fish.gis.model.PlanetOsmPolygon;
import org.fish.service.GisService;

import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ubu on 02.06.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LineRepositoryTests {


    @Autowired
    private GisService gisService;



    @Test
    public void findInterestingWays() {

        List<MarkerCoords>  markerData =  gisService.findInterestingWays();

        System.out.println(markerData.size());

    }

}
