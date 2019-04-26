package com.tgy.springbootmybatis;

import org.apache.ibatis.javassist.ClassPath;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.tgy.springbootmybatis.service","com.tgy.springbootmybatis.service.impl"})
@EnableCaching
public class SpringbootmybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootmybatisApplication.class, args);
    }
}
