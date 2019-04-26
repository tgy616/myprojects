package com.tgy.springasyncdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * DemoApplication
 *
 * @author DragonSwimDiving
 * @program springAsyncDemo
 * @date 2019-04-26 15:42
 **/
@SpringBootApplication
@EnableAsync
public class DemoApplication {

    @Autowired
    AsyncCaller caller;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        return args->{
            caller.rightWayToCall();
            Thread.sleep(1000);
            System.out.println("++++++++++++++++++++++++++++++");
            Thread.sleep(1000);
            caller.wrongWayToCall();
        };
    }
}
