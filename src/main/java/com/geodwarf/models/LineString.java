package com.geodwarf.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity(name="LineString")
@Table(name="linestring")
public class LineString {

    @Id
    @Column(name = "linestring_id")
    @GeneratedValue
    private int linestringId;

    @OneToMany(mappedBy="lineString", cascade = CascadeType.ALL)
    private Set<Point> points;

    public int getLinestringId() {
        return linestringId;
    }

    public void setLinestringId(int linestringId) {
        this.linestringId = linestringId;
    }

    public Set<Point> getPoints() {
        return points;
    }

    public void setPoints(Set<Point> points) {
        this.points = points;
    }
}
