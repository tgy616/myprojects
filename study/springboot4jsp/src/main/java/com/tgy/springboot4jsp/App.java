package com.tgy.springboot4jsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author tanggy
 * @date 2018/5/9
 */
@SpringBootApplication
//@ComponentScan(basePackages = {"com.tgy.springboot4jsp.controller","com.tgy.springboot4jsp.service"})
@EnableAutoConfiguration
public class App {
    public static void main(String[] args) {
        //主函数springboot项目的运行入口
        SpringApplication.run(App.class,args);
    }

}
