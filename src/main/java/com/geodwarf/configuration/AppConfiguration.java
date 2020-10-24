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
        points.add(new Point("3", "55"));
        points.add(new Point("5", "77"));
        points.add(new Point("42","12"));
        return points;
    }

}


