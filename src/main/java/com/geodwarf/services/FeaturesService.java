package com.geodwarf.services;

import com.geodwarf.dao.PointDao;
import com.geodwarf.models.Point;
import com.geodwarf.models.PointsCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class FeaturesService {

    private PointDao pointDao;

    @Autowired
    public FeaturesService(PointDao pointDao){
        this.pointDao = pointDao;
    }

    public ArrayList<Point> getAllPoints() {
        ArrayList<Point> pointsCollection = (ArrayList<Point>)pointDao.findAll();
        return pointsCollection;
    }
}
