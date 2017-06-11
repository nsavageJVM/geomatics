package org.fish.controller;

import org.fish.dto.MarkerCoords;
import org.fish.dto.MarkerDTO;
import org.fish.service.GisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by ubu on 29.05.17.
 */
@RestController
@RequestMapping("/gis")
public class PostGisController {

    private static final Logger logger = LoggerFactory.getLogger(PostGisController.class);


    @Autowired
    private GisService gisService;


    @RequestMapping(value="/markers", method= RequestMethod.GET)
    public @ResponseBody
    MarkerDTO getMarkers() {

        List<MarkerCoords> markerData =  gisService.findInterestingWays();
        MarkerDTO dto = new MarkerDTO(markerData);

        logger.info("Getting markerData, size = {} ", dto.getMarkerCoords().size());

        return dto;
    }



}
