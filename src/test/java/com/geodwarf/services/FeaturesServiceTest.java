package com.geodwarf.services;

import com.geodwarf.models.Point;
import com.geodwarf.models.PointsCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FeaturesServiceTest {

    @InjectMocks
    FeaturesService featuresService;

    @Mock
    PointsCollection pointsCollection;

    @Test
    public void whenGetPointsIsCalledItReturnACollectionOfPoints() {
        //given

        //when
        featuresService.getPointsCollection();
        //then

        verify(pointsCollection,times(1)).getPoints();
        assertThat(pointsCollection.getPoints(), instanceOf(ArrayList.class));

    }
}
