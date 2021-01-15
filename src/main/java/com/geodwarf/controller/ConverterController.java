package com.geodwarf.controller;

import com.geodwarf.models.GeoJsonCoordinates;
import com.geodwarf.models.KmlCoordinates;
import com.geodwarf.services.ConverterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ConverterController {

    //TODO check how to throw the exception

    private ConverterService converterService;
    private Logger logger  = LoggerFactory.getLogger(ConverterService.class);

    @Autowired
    public ConverterController(ConverterService converterService){
        this.converterService = converterService;
    }

    @RequestMapping(value="/convertcoordinates/kml/geojson", method = RequestMethod.POST)
    public GeoJsonCoordinates convertToJsonCoordinates(@Valid @RequestBody KmlCoordinates kmlCoordinates) throws Exception{
        logger.info("I have been hit by a request");
        return converterService.convert(kmlCoordinates);
    }
}