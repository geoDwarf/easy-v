package com.geodwarf.services;

import com.geodwarf.models.Point;
import com.geodwarf.models.PointsCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class FeaturesService {

    @Autowired
    private PointsCollection pointsCollection;

    public ArrayList<Point> getPointsCollection() {

        return pointsCollection.getPoints();
    }
}
