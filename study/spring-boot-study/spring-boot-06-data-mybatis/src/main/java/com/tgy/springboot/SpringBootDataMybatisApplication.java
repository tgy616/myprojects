package com.tgy.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.tgy.springboot.mapper")
@SpringBootApplication
public class SpringBootDataMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataMybatisApplication.class, args);
	}
}
