package com.geodwarf.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
}
