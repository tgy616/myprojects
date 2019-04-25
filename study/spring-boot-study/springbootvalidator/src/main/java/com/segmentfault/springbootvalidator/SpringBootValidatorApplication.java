package com.segmentfault.springbootvalidator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.segmentfault")
public class SpringBootValidatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootValidatorApplication.class, args);
    }
}
