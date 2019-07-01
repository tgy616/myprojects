package com.tgy.springbootstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class SpringbootstartApplication {

    public static void main(String[] args) {
        SpringApplication springApplication=new SpringApplication(SpringBootConfiguration.class);
        springApplication.setWebEnvironment(true);
        springApplication.run(args);
    }

}
