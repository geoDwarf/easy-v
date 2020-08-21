package com.geodwarf;

import com.geodwarf.dao.PointDao;
import com.geodwarf.models.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */

@RestController
@SpringBootApplication
public class Application implements CommandLineRunner
{
    //TODO add Junit test for persistence
    @Autowired
    PointDao pointDao;

    public static void main( String[] args )
    {

        SpringApplication.run(Application.class, args);
        System.out.println( "Hello World!" );


    }

    @Override
    public void run(String... strings) throws Exception {
        //TODO move the DB initialization
        initializeDB();
    }

    @RequestMapping("/")
    String helloWorld() {
        return "Hello World!";
    }

    private void initializeDB(){
        //TODO move the DB initialization
        Point point1 = new Point();
        Point point2 = new Point();

        point1.setX("11");
        point1.setY("42");
        point1.setPointId("0");
        point2.setX("52");
        point2.setY("18");
        point2.setPointId("1");

        pointDao.save(point1);
        pointDao.save(point2);
    }

}
