package com.geodwarf.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PointCollectionTest {

    @Autowired
    private PointsCollection pointsCollection;

    Point pointExpectedOne = new Point("3", "55");
    Point pointExpectedTwo = new Point("5", "77");
    Point pointExpectedThree = new Point ("42","12");

    @Test
    public void pointCollectionInitializationTest(){

        // given point collection has been initialized;
        ArrayList<Point> points =  pointsCollection.getPoints();

        //when i get the points
        Point pointActualOne = points.get(0);
        Point pointActualTwo = points.get(1);
        Point pointActualThree = points.get(2);

        //then it is populated as expected
        assertTrue(pointActualOne.getX().equals(pointExpectedOne.getX()));
        assertTrue(pointActualOne.getY().equals(pointExpectedOne.getY()));

        assertTrue(pointActualTwo.getX().equals(pointExpectedTwo.getX()));
        assertTrue(pointActualTwo.getY().equals(pointExpectedTwo.getY()));

        assertTrue(pointActualThree.getX().equals(pointExpectedThree.getX()));
        assertTrue(pointActualThree.getY().equals(pointExpectedThree.getY()));
    }
}
