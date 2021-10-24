package com.geodwarf;

import com.geodwarf.dao.PointDao;
import com.geodwarf.models.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class Application  //implements CommandLineRunner
{
    //TODO add Junit test for persistence
    @Autowired
    PointDao pointDao;

    public static void main( String[] args )
    {
        SpringApplication.run(Application.class, args);
        System.out.println( "Hello World!" );
    }

    @RequestMapping("/")
    String helloWorld() {
        return "Hello World!";
    }


}
