package com.geodwarf.dao;

import com.geodwarf.models.Point;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;


@DataJpaTest
@RunWith(SpringRunner.class)
public class PointDaoTest {

    @Autowired
    private PointDao pointDao;

    private Point point1;
    private Point point2;

    private Point pointFound1;
    private Point pointFound2;


    @Before
    public void init(){
        point1 = new Point();
        point2 = new Point();
    }

    @Test
    public void whenSavePointThenItIsPossibleToFetchIt(){

        //given
        pointDao.save(point1);
        //when
        pointFound1 = pointDao.findById(point1.getPointId()).get();
        //then
        assertEquals(pointFound1.getPointId(), point1.getPointId());
    }

    @Test
    public void whenSavePointThenItIsPossibleToDeleteIt() {

        //given
        pointDao.save(point1);
        //when
        pointDao.delete(point1);
        boolean pointFound = pointDao.findById(point1.getPointId()).isPresent();
        //then
        assertFalse(pointFound);
    }

    @Test public void whenWeSaveTwoDifferentPointsTheyMustHaveDifferentId (){
        //given
        pointDao.save(point1);
        pointDao.save(point2);
        //when
        pointFound1 = pointDao.findById(point1.getPointId()).get();
        pointFound2 = pointDao.findById(point2.getPointId()).get();

        assertNotEquals(pointFound2.getPointId(),pointFound1.getPointId());
    }

    //TODO X znd Y coordinates in Point class should not be nullable, think about change class and test accordingly.

    }

