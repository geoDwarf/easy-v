package com.geodwarf.services;

import com.geodwarf.errors.CoordinatesFormatException;
import com.geodwarf.errors.CoordinatesNumberException;
import com.geodwarf.models.GeoJsonCoordinates;
import com.geodwarf.models.KmlCoordinates;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;


@Component
public class ConverterService {

    //TODO add Log class and logs
    //TODO Refactor this class

    public GeoJsonCoordinates convert(KmlCoordinates kmlCoordinates) throws CoordinatesNumberException, CoordinatesFormatException {
        String coordinates= kmlCoordinates.getCoordinates();
        int countComa = 0;
        int countEmpty = 0;
        for (int i = 0; i < coordinates.length(); i++) {
            if (coordinates.charAt(i) == ',') {
                countComa++;
            }
            if(coordinates.charAt(i) == ' '){
                countEmpty++;
            }
        }

        if(countEmpty*2 == countComa || (countEmpty+1)*2 == countComa){
            System.out.println("happy days");
        }else{
            throw new CoordinatesNumberException("Wrong number of coordinates");
        }

        if (!coordinateIsNumeric(coordinates)){
            throw new CoordinatesFormatException("Wrong coordinates format");
        }

        System.out.println("coma: " + countComa);
        System.out.println("space: " + countEmpty);



        GeoJsonCoordinates geoJsonCoordinates = new GeoJsonCoordinates();
        geoJsonCoordinates.setCoordinatesAsArrayOfDouble(createArrayForJsonCoordinates(coordinates));
        return geoJsonCoordinates;
    }

    private boolean coordinateIsNumeric(String coordinates){
        String[] coordinatesArray = coordinates.split(" ");
        String singleCoordinateToCheck ;
        for(int i = 0; i<coordinatesArray.length; i++){
            for (int j = 0; j < coordinatesArray[i].split(",").length; j++ ){
                singleCoordinateToCheck =  coordinatesArray[i].split(",")[j];
                try {
                    Double.parseDouble(singleCoordinateToCheck);
                }catch(NumberFormatException e){
                    return false;
                }
            }
        }
        return true;
    }

    private ArrayList<ArrayList<Double>> createArrayForJsonCoordinates(String coordinates){
        String[] coordinatesArray = coordinates.split(" ");
        ArrayList<ArrayList<String>> arrayOut = new ArrayList<>();
        for(int i = 0; i<coordinatesArray.length; i++){
            ArrayList<String> innerArray =  new ArrayList<>(Arrays.asList(coordinatesArray[i].split(",")));
            innerArray.remove(2);
                arrayOut.add(innerArray);
        }
            return convertToIntArray(arrayOut);
    }


    private ArrayList<ArrayList<Double>> convertToIntArray(ArrayList<ArrayList<String>> stringArrayOfArrays){
        ArrayList<ArrayList<Double>> outArray= new ArrayList<>();
         for(int i = 0; i <stringArrayOfArrays.size(); i++){
             ArrayList<Double> tempArray = new ArrayList<>();
             for(int j = 0; j < stringArrayOfArrays.get(i).size(); j++){
                 tempArray.add(Double.parseDouble( stringArrayOfArrays.get(i).get(j)));
             }
             outArray.add(tempArray);
         }
        return outArray;

    }

}
