package com.geodwarf.dao;

import com.geodwarf.models.LineString;
import com.geodwarf.models.Point;
import com.geodwarf.utils.DataInit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
public class LineStringDaoTest {

    @Autowired
    private LineStringDao lineStringDao;
    @Autowired
    private PointDao pointDao;

    private LineString correctLineString;

    @Test
    public void whenWeHaveACorrectStringWeCanSaveIt(){
        //given
        givenACorrectLineString();
        //when
        try{
        lineStringDao.save(correctLineString);
        //then
        }catch(InvalidDataAccessApiUsageException dataAccessException) {
            System.out.println("Save linestring Test failed, exception should ot be thrown ");
            fail();
        }
    }

    @Test
    public void whenWeHaveACorrectStringWeCanSaveAndFetchIt(){
        //given
        givenACorrectLineString();
        //when
        lineStringDao.save(correctLineString);
        //then
        try{
            lineStringDao.findById(correctLineString.getLinestringId());
        }catch(InvalidDataAccessApiUsageException dataAccessException) {
            System.out.println("Save linestring Test failed, exception should ot be thrown ");
            fail();
        }
    }

    @Test
    public void whenEverythingIsCorrectWeCanSaveAndDeleteALineString(){
        //given
        givenACorrectLineString();
        //when
        lineStringDao.save(correctLineString);
        //then
        try{
            lineStringDao.deleteById(correctLineString.getLinestringId());
        }catch(InvalidDataAccessApiUsageException dataAccessException) {
            System.out.println("Save linestring Test failed, exception should ot be thrown ");
            fail();
        }
    }

    @Test
    public void whenWeDeleteAStringWeEvenDeleteAllTheRelativesPoints(){
        //given
        givenACorrectLineString();
        //when
        lineStringDao.save(correctLineString);
        Optional stringFound = lineStringDao.findById(correctLineString.getLinestringId());
        LineString lineStringfound = (LineString)stringFound.get();
        Set<Point> points=  lineStringfound.getPoints();
        int firstIdFound = getFirstPointId(points);
        lineStringDao.deleteById(correctLineString.getLinestringId());
        //then
        assertEquals(Optional.empty(), pointDao.findById(firstIdFound));
    }


    private void givenACorrectLineString(){

        correctLineString = new LineString();
        Set<Point> pointSet = new HashSet<>();
        Point stringPoint = new Point();
        Point stringPoint2 = new Point();
        stringPoint.setX("12");
        stringPoint.setY("42");
        pointSet.add(stringPoint);
        pointSet.add(stringPoint2);
        correctLineString.setPoints(pointSet);

        System.out.println("linestring id:  "+correctLineString.getLinestringId());

        }

        private int getFirstPointId(Set<Point> points){
            int firstIdFound = 0;
            for(Point point : points){
                firstIdFound = point.getPointId();
                break;
            }
            return firstIdFound;
        }
    }

