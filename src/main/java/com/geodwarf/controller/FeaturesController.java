package com.geodwarf.controller;

import com.geodwarf.models.Point;
import com.geodwarf.services.FeaturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class FeaturesController {

    @Autowired
    FeaturesService featuresService;

    @GetMapping("/getpoints")
    public ArrayList<Point> getPoints(){
        return featuresService.getAllPoints();
    }

    @GetMapping("/prova")
    public String prova(){
        return "stringa prova";
    }
}
