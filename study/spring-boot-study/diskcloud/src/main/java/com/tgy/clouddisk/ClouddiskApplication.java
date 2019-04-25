package com.tgy.clouddisk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(value = "com.tgy.clouddisk.mapper")

@EnableAutoConfiguration(exclude={
        JpaRepositoriesAutoConfiguration.class//禁止springboot自动加载持久化bean
})
@EnableTransactionManagement
public class ClouddiskApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClouddiskApplication.class, args);
    }
}
