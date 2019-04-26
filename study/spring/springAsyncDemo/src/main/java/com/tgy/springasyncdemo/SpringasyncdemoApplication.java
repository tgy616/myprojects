package com.tgy.springasyncdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringasyncdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringasyncdemoApplication.class, args);
    }

}
