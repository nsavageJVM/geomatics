package org.fish.dao;

import org.fish.gis.model.PlanetOsmPolygon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * https://gis.stackexchange.com/questions/163173/how-do-i-convert-the-coordinate-data-from-osm-into-actual-longitude-latitude-poi
   https://stackoverflow.com/questions/2217083/java-transform-projection-epsg900913-to-epsg4326
 */
@Repository
public interface PolygonRepository extends CrudRepository<PlanetOsmPolygon, Integer> {


    @Query("select p from PlanetOsmPolygon p where p.tourism is not null")
    List<PlanetOsmPolygon> findInterestingWays( );

}
