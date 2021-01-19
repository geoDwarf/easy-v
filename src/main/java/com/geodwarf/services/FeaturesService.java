package com.geodwarf.services;

import com.geodwarf.dao.LineStringDao;
import com.geodwarf.dao.PointDao;
import com.geodwarf.models.LineString;
import com.geodwarf.models.Point;
import com.geodwarf.models.PointsCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

@Component
public class FeaturesService {

    private PointDao pointDao;
    private LineStringDao lineStringDao;

    @Autowired
    public FeaturesService(PointDao pointDao, LineStringDao lineStringDao){
        this.pointDao = pointDao;
        this.lineStringDao = lineStringDao;
    }

    public ArrayList<Point> getAllPoints() {
        Objects.requireNonNull(pointDao,"pointDao cannot be null");
        ArrayList<Point> pointsCollection = (ArrayList<Point>)pointDao.findAll();
        return pointsCollection;
    }

    public ArrayList<LineString> getAllLineString() {
        Objects.requireNonNull(lineStringDao,"lineStringDao cannot be null");
        ArrayList<LineString> lineStrings = (ArrayList<LineString>)lineStringDao.findAll();
        return lineStrings;
    }

    protected void setLineStringDao(LineStringDao lineStringDao) {
        this.lineStringDao = lineStringDao;
    }

    public void setPointDao(PointDao pointDao) {
        this.pointDao = pointDao;
    }
}
