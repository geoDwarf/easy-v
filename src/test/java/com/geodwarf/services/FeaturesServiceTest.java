package com.geodwarf.services;

import com.geodwarf.dao.PointDao;
import com.geodwarf.models.Point;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FeaturesServiceTest {

    @InjectMocks
    FeaturesService featuresService;

    @Mock
    PointDao pointDao;

    @Mock
    ArrayList<Point> pointsCollection;

    @Test
    public void whenGetPointsIsCalledItReturnACollectionOfPoints() {
        //given
        when(pointDao.findAll()).thenReturn(pointsCollection);
        //when
        featuresService.getAllPoints();
        //then
        verify(pointDao,times(1)).findAll();
        assertThat(featuresService.getAllPoints(), instanceOf(ArrayList.class));

    }


    @Test
    public void whenGetPointsIsCalledAndReturnsANullCollection() {
        //given
        when(pointDao.findAll()).thenReturn(null);
        //when
        featuresService.getAllPoints();
        //then
        verify(pointDao,times(1)).findAll();
        assertNull(featuresService.getAllPoints());

    }
}
