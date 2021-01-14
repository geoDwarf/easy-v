package com.geodwarf.models;

import java.util.ArrayList;

public class GeoJsonCoordinates {

    private String coordinatesAsString;

    private ArrayList<ArrayList<Double>> coordinatesAsArrayOfDouble;

    public String getCoordinatesAsString() {
        return coordinatesAsString;
    }

    public void setCoordinatesAsString(String coordinatesAsString) {
        this.coordinatesAsString = coordinatesAsString;
    }

    public ArrayList<ArrayList<Double>> getCoordinatesAsArrayOfDouble() {
        return coordinatesAsArrayOfDouble;
    }

    public void setCoordinatesAsArrayOfDouble(ArrayList<ArrayList<Double>> coordinatesAsArrayOfDouble) {
        this.coordinatesAsArrayOfDouble = coordinatesAsArrayOfDouble;
    }
}
