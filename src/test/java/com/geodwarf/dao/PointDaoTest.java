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


@DataJpaTest
@RunWith(SpringRunner.class)
public class PointDaoTest {

    @Autowired
    private PointDao pointDao;


    private Point point;

    private Point pointFound;

    @Before
    public void init(){
        point = new Point();
    }


    @Test
    public void whenSavePointThenItIsPossibleToFetchIt(){

        //given
        pointDao.save(point);
        //when
        pointFound = pointDao.findById(point.getPointId()).get();
        //then
        assertEquals(pointFound.getPointId(), point.getPointId());
    }

    @Test
    public void whenSavePointThenItIsPossibleToDeleteIt() {

        //given
        pointDao.save(point);
        //when
        pointDao.delete(point);
        boolean pointFound = pointDao.findById(point.getPointId()).isPresent();
        //then
        assertFalse(pointFound);
    }

    }

