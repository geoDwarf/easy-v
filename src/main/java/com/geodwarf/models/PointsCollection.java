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
        Point point1 = new Point();
        Point point2 = new Point();
        point1.setX("12");
        point1.setY("42");
        point2.setX("11");
        point2.setY("42");
        points.add(point1);
        points.add(point2);
    }

    public ArrayList<Point> getPoints() {
        return points;
    }
}
