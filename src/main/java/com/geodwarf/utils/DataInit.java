package com.geodwarf.utils;

import com.geodwarf.dao.PointDao;
import com.geodwarf.models.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInit {

    private PointDao pointDao;

    @Autowired
    public DataInit(PointDao pointDao){
        this.pointDao = pointDao;
    }

    public void init(){
        Point point1 = new Point();
        Point point2 = new Point();
        Point point3 = new Point();
        Point point4 = new Point();
        Point point5 = new Point();
        Point point6 = new Point();
        Point point7 = new Point();


        point1.setX("12.678");
        point1.setY("42.990");
        point2.setX("11.768");
        point2.setY("42.006");
        point3.setX("12.445");
        point3.setY("42.096");
        point4.setX("12.345");
        point4.setY("42.523");
        point5.setX("12.45474149");
        point5.setY("41.99917957");
        point6.setX("12.41137649");
        point6.setY("42.07122433");
        point7.setX("12.40593233");
        point7.setY("42.03279687");

        pointDao.save(point1);
        pointDao.save(point2);
        pointDao.save(point3);
        pointDao.save(point4);
        pointDao.save(point5);
        pointDao.save(point6);
        pointDao.save(point7);


    }
}
