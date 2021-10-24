package com.geodwarf.services;

import com.geodwarf.dao.PointDao;
import com.geodwarf.models.Point;
import com.geodwarf.models.PointsCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class FeaturesService {

    @Autowired
    private PointsCollection pointsCollection;

    @Autowired
    private PointDao pointDao;

    public ArrayList<Point> getPointsCollection() {
        //ArrayList<Point> points = (ArrayList<Point>) pointDao.findAll();
        //pointsCollection.setPoints(points);
        Long longo = 3455L;
        return pointsCollection.getPoints();

    }
}
