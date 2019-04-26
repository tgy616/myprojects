package com.tgy.springbootdemo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author tanggy
 * @date 2018/5/9
 */
@ComponentScan(basePackages = {"com.tgy.springbootdemo.controller", "com.tgy.springbootdemo.service"})
@EnableJpaRepositories("com.tgy.springbootdemo.dao")
@EnableAutoConfiguration
@EntityScan("com.tgy.springbootdemo.entity")
public class App {
    public static void main(String[] args) {
        //主函数springboot项目的运行入口
        SpringApplication.run(App.class,args);
    }

}
