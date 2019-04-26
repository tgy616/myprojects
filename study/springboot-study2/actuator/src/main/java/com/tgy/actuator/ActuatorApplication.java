package com.tgy.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自定义健康状态指示器
 * 1、编写一个指示器，实现HealthIndicator
 * 2、指示器的名字 xxxHealthIndicator
 */
@SpringBootApplication
public class ActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActuatorApplication.class, args);
    }
}
