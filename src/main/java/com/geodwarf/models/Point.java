package com.geodwarf.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="points")
public class Point {

    @Id
    @Column(name = "POINT_ID")
    @GeneratedValue
    private int pointId;
    @Column(name = "X")
    private String x ;
    @Column(name = "Y")
    private String y ;

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "linestringId")
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name="linestring_id", nullable=true)
    private LineString lineString;

    public Point(String x, String y ){
        this.x = x;
        this.y = y;
    }

    //TODO Find how to keep a no parameter constructor
    public Point(){

    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    public int getPointId() {
        return pointId;
    }

    public void setPointId(int pointId) {
        this.pointId = pointId;
    }

    public void setX(String x) {
        this.x = x;
    }

    public void setY(String y) {
        this.y = y;
    }

    public LineString getLineString() {
        return lineString;
    }

    public void setLineString(LineString lineString) {
        this.lineString = lineString;
    }
}
