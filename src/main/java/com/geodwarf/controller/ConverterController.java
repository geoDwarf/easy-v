package com.geodwarf.controller;

import com.geodwarf.models.KmlCoordinates;
import com.geodwarf.services.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ConverterController {

    private ConverterService converterService;

    @Autowired
    public ConverterController(ConverterService converterService){
        this.converterService = converterService;
    }

    @RequestMapping(value="/convertcoordinates/kml/geojson", method = RequestMethod.POST)
    public void converToJsonCoordinates(@Valid @RequestBody KmlCoordinates kmlCoordinates){

    }
}