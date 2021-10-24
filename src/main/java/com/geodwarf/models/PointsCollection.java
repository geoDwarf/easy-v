package com.geodwarf.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PointsCollection {

    ArrayList<Point> points;

    @Autowired
    public PointsCollection(ArrayList<Point> points) {
        this.points=points;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
}
