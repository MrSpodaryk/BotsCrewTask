package com.spodaryk;

import com.spodaryk.views.ApplicationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BotsCrewTaskApplication {

    @Autowired
    ApplicationView view;

    public static void main(String[] args) {
        SpringApplication.run(BotsCrewTaskApplication.class, args);
    }
}
