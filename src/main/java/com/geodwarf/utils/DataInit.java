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

        point1.setX("12.678");
        point1.setY("42.990");
        point2.setX("11.768");
        point2.setY("42.006");
        point3.setX("12.445");
        point3.setY("42.096");
        point4.setX("12.345");
        point4.setY("42.523");

        pointDao.save(point1);
        pointDao.save(point2);
        pointDao.save(point3);
        pointDao.save(point4);


    }
}
