package com.geodwarf.services;


import com.geodwarf.errors.CoordinatesFormatException;
import com.geodwarf.errors.CoordinatesNumberException;
import com.geodwarf.models.GeoJsonCoordinates;
import com.geodwarf.models.KmlCoordinates;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = ConverterService.class)
@RunWith(SpringRunner.class)
public class ConverterServiceTest {

    private final String WRONG_COORDINATES_NUMBER = "12.44563212,41.96781604,0 12.44562437,41.96781583,0 12.44561823,";
    private final String CORRECT_COORDINATES_NO_END_SPACE = "12.44563212,41.96781604,0 12.44562437,41.96781583,0 12.44561823,41.96781776,0 12.44561648,41.96782113,0" +
            " 12.44561543,41.96782358,0 12.44561369,41.96782849,0 12.4456057,41.96782395,0 12.44560245,41.96781305,0 12.44559708,41.96780106,0" +
            " 12.44559316,41.96779111,0 12.44559255,41.96778165,0 12.44559294,41.96777318,0";
    private final String WRONG_COORDINATES_FORMAT = "12.4453212,41.96781604,0 12.44562437,AB.LLOO,0 ";

    private final String CORRECT_COORDINATES = "12.44563212,41.96781604,0 12.44562437,41.96781583,0 12.44561823,41.96781776,0 12.44561648,41.96782113,0 ";
    private ArrayList<ArrayList<Double>> expectedArrayList = new ArrayList<>();



    @Autowired
    private ConverterService converterService;

    @Mock
    private KmlCoordinates kmlCoordinates;


    @Test(expected = CoordinatesNumberException.class)
    public void whenNumberOfCoordinatesIsWrongThrowsException() throws CoordinatesNumberException, CoordinatesFormatException {
        //given
        when(kmlCoordinates.getCoordinates()).thenReturn(WRONG_COORDINATES_NUMBER);
        //when
        converterService.convert(kmlCoordinates);
        //then
    }

    @Test(expected = CoordinatesFormatException.class)
    public void whenCoordinatesHaveWrongFormatThrowsException() throws CoordinatesNumberException, CoordinatesFormatException {
        //given
        when(kmlCoordinates.getCoordinates()).thenReturn(WRONG_COORDINATES_FORMAT);
        //when
        converterService.convert(kmlCoordinates);
        //then
    }

    @Test
    public void whenNumberOfCoordinatesIsCorrectReturnExpectedJson() throws CoordinatesNumberException, CoordinatesFormatException{
        //given
        givenAnExpectedCoordinatesList();
        when(kmlCoordinates.getCoordinates()).thenReturn(CORRECT_COORDINATES);
        //when
        GeoJsonCoordinates geoJsonCoordinates = converterService.convert(kmlCoordinates);
        //then
        assertEquals(expectedArrayList.get(0),geoJsonCoordinates.getCoordinatesAsArrayOfDouble().get(0));
        assertEquals(expectedArrayList.get(1),geoJsonCoordinates.getCoordinatesAsArrayOfDouble().get(1));
    }

    @Test
    public void whenNumberOfCoordinatesIsCorrectAndWithNoEndSpaceReturnExpectedJson() throws CoordinatesNumberException, CoordinatesFormatException{
        //given
        givenAnExpectedCoordinatesList();
        when(kmlCoordinates.getCoordinates()).thenReturn(CORRECT_COORDINATES_NO_END_SPACE);
        //when
        GeoJsonCoordinates geoJsonCoordinates = converterService.convert(kmlCoordinates);
        //then
        assertEquals(expectedArrayList.get(0),geoJsonCoordinates.getCoordinatesAsArrayOfDouble().get(0));
        assertEquals(expectedArrayList.get(1),geoJsonCoordinates.getCoordinatesAsArrayOfDouble().get(1));
    }


    private void givenAnExpectedCoordinatesList(){
        ArrayList<Double> arrayList1 = new ArrayList<>();
        ArrayList<Double> arrayList2 = new ArrayList<>();
        ArrayList<Double> arrayList3 = new ArrayList<>();
        ArrayList<Double> arrayList4 = new ArrayList<>();

        arrayList1.add(12.44563212);
        arrayList1.add(41.96781604);
        arrayList2.add(12.44562437);
        arrayList2.add(41.96781583);
        arrayList3.add(12.44561823);
        arrayList3.add(41.96781776);
        arrayList4.add(12.44561648);
        arrayList4.add(41.96782113);

        expectedArrayList.add(arrayList1);
        expectedArrayList.add(arrayList2);
        expectedArrayList.add(arrayList2);
        expectedArrayList.add(arrayList3);

    }

}
