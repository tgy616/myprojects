package com.tgy.springbootproperty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"META-INF/spring/context.xml"})
public class SpringbootpropertyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootpropertyApplication.class, args);
    }

}
