package com.geodwarf.controller;

import com.geodwarf.services.FeaturesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FeaturesControllerTest {

    //TODO make this test class more meaningful

    @InjectMocks
    private FeaturesController featuresController;

    @Mock
    private FeaturesService featuresService;

    @Test
    public void getPointsCallTheCorrectMethod(){
        //given

        //when
        featuresController.getPoints();
        //then
        verify(featuresService,times(1)).getAllPoints();
    }

    @Test
    public void getLineStringCallTheCorrectMethod(){
        //given

        //when
        featuresController.getLineStrings();
        //then
        verify(featuresService,times(1)).getAllLineString();
    }
}
