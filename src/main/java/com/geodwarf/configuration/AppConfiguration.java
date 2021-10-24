package com.geodwarf.configuration;

import com.geodwarf.models.Point;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class AppConfiguration {

    @Bean
    public ArrayList<Point> getPoints(){
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point("12.09", "42.0505"));
        points.add(new Point("12.55", "42.16"));
        points.add(new Point("12.31", "42.40"));
        points.add(new Point("0.12", "52.20"));
        points.add(new Point("0","0"));
        return points;
    }

}


