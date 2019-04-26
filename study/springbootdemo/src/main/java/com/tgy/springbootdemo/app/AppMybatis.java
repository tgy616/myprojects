
package com.tgy.springbootdemo.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com.tgy.springbootdemo.dao" })
@MapperScan(basePackages = { "com.tgy.springbootdemo.mapper" })
@EnableAutoConfiguration
public class AppMybatis {
	public static void main(String[] args) {
		SpringApplication.run(AppMybatis.class, args);
	}

}
