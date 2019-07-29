package edu.northeastern.cs5200;

import edu.northeastern.cs5200.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HungryjackApplication {


    public static void main(String[] args) {
        SpringApplication.run(HungryjackApplication.class, args);
    }
}
