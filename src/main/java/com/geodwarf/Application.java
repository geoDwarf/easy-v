package com.geodwarf;

import com.geodwarf.utils.DataInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;


@RestController
@SpringBootApplication
@ComponentScan(basePackages ={
"com.geodwarf.dao", "com.geodwarf.utils"})
public class Application
{

    @Autowired
    private DataInit dataInit;

    public static void main( String[] args )
    {
        SpringApplication.run(Application.class, args);
    }


    @PostConstruct
    public void initDB(){
        dataInit.init();
}

    @RequestMapping("/")
    String helloWorld() {
        return "THE BACKEND IS ON!";
    }



}
