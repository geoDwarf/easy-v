package com.geodwarf.utils;

import com.geodwarf.dao.LineStringDao;
import com.geodwarf.dao.PointDao;
import com.geodwarf.models.LineString;
import com.geodwarf.models.Point;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * This class initializes the database with default value, it gets the value for the linestring from
 * a JSON file. In future it should be moved to an SQL script for inserting all the default values
 */
@Component
public class DataInit {

    private PointDao pointDao;
    private LineStringDao lineStringDao;


    @Autowired
    public DataInit(PointDao pointDao, LineStringDao lineStringDao){
        this.pointDao = pointDao;
        this.lineStringDao = lineStringDao;
    }



    public void init() throws IOException{
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
        try{
            initLineStrings();
        }
        catch(ParseException pe){

            pe.printStackTrace();
        }
    }

    private void initLineStrings() throws IOException, ParseException {

        JSONObject jsonObject = readDefaultJson();
        JSONArray coordinates = (JSONArray) jsonObject.get("coordinates");
        Iterator<JSONArray> JSONArrayiterator = coordinates.iterator();
        Set<Point> pointSet = new HashSet<>();
        LineString lineString = new LineString();
        while (JSONArrayiterator.hasNext()){
            JSONArray arrayCoordinates = JSONArrayiterator.next();
            Point stringPoint = new Point(String.valueOf(arrayCoordinates.get(0)), String.valueOf(arrayCoordinates.get(1)));
            stringPoint.setLineString(lineString);
            pointSet.add(stringPoint);
        }
        lineString.setPoints(pointSet);
        lineStringDao.save(lineString);
    }

    private JSONObject readDefaultJson() throws IOException, ParseException {
        Resource resource = new ClassPathResource("lineStringDefault.json");
        File file = resource.getFile();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(file));
        JSONObject jsonObject = (JSONObject) obj;

        return jsonObject;
    }
}
