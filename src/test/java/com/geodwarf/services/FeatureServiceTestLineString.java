package com.geodwarf.services;

import com.geodwarf.dao.LineStringDao;
import com.geodwarf.models.LineString;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FeatureServiceTestLineString {

    private ArrayList<LineString> expectedLineStrings;

    @InjectMocks
    private FeaturesService featuresService;

    @Mock
    private LineStringDao lineStringDao;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void init(){
        expectedLineStrings = new ArrayList<>();
    }

    @Test
    public void whenEverythingIsCorrectReturnsExpectedLinestring(){
        //given
        when(lineStringDao.findAll()).thenReturn(expectedLineStrings);
        //when
        ArrayList<LineString> actualLineStrings =featuresService.getAllLineString();
        //then
        verify(lineStringDao,times(1)).findAll();
        assertThat(featuresService.getAllLineString(), instanceOf(ArrayList.class));
        assertEquals(expectedLineStrings, actualLineStrings);
    }

    @Test
    public void whenLineStringDaoIsNullExpectedException() throws NullPointerException{
        thrown.expectMessage("lineStringDao cannot be null");
        //given
        featuresService.setLineStringDao(null);
        //when
        featuresService.getAllLineString();
        //then throws exception
    }

    @Test
    public void whenLineStringIsNotFoundServiceReturnNull(){
        //given
        when(lineStringDao.findAll()).thenReturn(null);
        //when
        ArrayList<LineString> actualLineStrings =featuresService.getAllLineString();
        //then
        verify(lineStringDao,times(1)).findAll();
        assertNull(actualLineStrings);
    }

}
