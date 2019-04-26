package com.tgy.springasyncdemo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 在类里使用 Async 注解
 *
 * @author DragonSwimDiving
 * @program spring-async
 * @date 2019-04-26 15:00
 **/
@Component
public class AsyncMailTrigger {

    @Async
    public void senMail(Map<String,String> properties){
        System.out.println("Trigger mail in a New Thread :: "+Thread.currentThread().getName());
        properties.forEach((K,V)->{
            System.out.println("key ::"+K+" Value ::"+V);
        });
    }

}
