package org.fish.gis.model;

import com.vividsolutions.jts.geom.Geometry;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by ubu on 02.06.17.
 */
@Entity
@Table(name="planet_osm_line")
@NoArgsConstructor
@Data
public class PlanetOsmLine implements Serializable {

    @Id
    @Column(name = "osmId")
    private Long osmId;

    private String access;
    @Column(name = "\"addr:housename\"")
    private String addr_housename;
    @Column(name = "\"addr:housenumber\"")
    private String addr_housenumber;
    @Column(name = "\"addr:interpolation\"")
    private String addr_interpolation;
    private String adminLevel;
    private String aerialway;
    private String aeroway;
    private String amenity;
    private String area;
    private String barrier;
    private String bicycle;
    private String brand;
    private String bridge;
    private String boundary;
    private String building;
    private String construction;
    private String covered;
    private String culvert;
    private String cutting;
    private String denomination;
    private String disused;
    private String embankment;
    private String foot;
    @Column(name = "\"generator:source\"")
    private String generator_source;
    private String harbour;
    private String highway;
    private String historic;
    private String horse;
    private String intermittent;
    private String junction;
    private String landuse;
    private String layer;
    private String leisure;
    private String lock;
    private String manMade;
    private String military;
    private String motorcar;
    private String name;
    private String natural;
    private String office;
    private String oneway;
    private String operator;
    private String place;
    private String population;
    private String power;
    private String powerSource;
    private String publicTransport;
    private String railway;
    private String ref;
    private String religion;
    private String route;
    private String service;
    private String shop;
    private String sport;
    private String surface;
    private String toll;
    private String tourism;
    @Column(name = "\"tower:type\"")
    private String tower_type;
    private String tracktype;
    private String tunnel;
    private String water;
    private String waterway;
    private String wetland;
    private String width;
    private String wood;
    private Integer ZOrder;
    private Float wayArea;
    private String tags;
    @Column(name = "way",columnDefinition="Geometry")
    private Geometry way;
}
