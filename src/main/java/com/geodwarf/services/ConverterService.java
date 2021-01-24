package com.geodwarf.services;

import com.geodwarf.errors.CoordinatesFormatException;
import com.geodwarf.errors.CoordinatesNumberException;
import com.geodwarf.models.GeoJsonCoordinates;
import com.geodwarf.models.KmlCoordinates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

//TODO think about make it more generic (e.g. if we need to convert point coordinates, at the moment it just converts string KML coordinates in to  geoJson string array)

@Component
public class ConverterService {

    private Logger logger  = LoggerFactory.getLogger(ConverterService.class);

    public GeoJsonCoordinates convert(KmlCoordinates kmlCoordinates) throws CoordinatesNumberException, CoordinatesFormatException {

        String coordinates= kmlCoordinates.getCoordinates();
        logger.info("Start Converting coordinates : " + coordinates);
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
        logger.info("coma: " + countComa);
        logger.info("space: " + countEmpty);
        logger.info("Checking coordinates number and format ....");

        checkCoordinatesFormatAndNumber(coordinates, countComa, countEmpty);

        GeoJsonCoordinates geoJsonCoordinates = new GeoJsonCoordinates();
        geoJsonCoordinates.setCoordinatesAsArrayOfDouble(createArrayForJsonCoordinates(coordinates));
        logger.info("Coordinates converted");
        return geoJsonCoordinates;
    }

    private void checkCoordinatesFormatAndNumber(String coordinates, int countComa, int countEmpty) throws CoordinatesNumberException, CoordinatesFormatException{

        if(!(countEmpty*2 == countComa || (countEmpty+1)*2 == countComa)){
            logger.error("Wrong number of coordinates");
            throw new CoordinatesNumberException("Wrong number of coordinates");
        }
        if (!coordinateIsNumeric(coordinates)){
            logger.error("Wrong coordinates format");
            throw new CoordinatesFormatException("Wrong coordinates format");
        }

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
            innerArray.remove(2); // we remove the zero as we don't have the height in geoJson
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
