package com.tgy.springasyncdemo;

import com.tgy.springasyncdemo.AsyncMailTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 调用类
 *
 * @author DragonSwimDiving
 * @program spring-async
 * @date 2019-04-26 15:05
 **/
@Component
public class AsyncCaller {
    @Autowired
    private AsyncMailTrigger asyncMailTriggerObject;

    public void rightWayToCall(){
        System.out.println("Calling From rightWayToCall Thread "+Thread.currentThread().getName());
        asyncMailTriggerObject.senMail(populateMap());
    }

    public void wrongWayToCall(){
        System.out.println("Calling From wrongWayToCall Thread "+Thread.currentThread().getName());
        AsyncMailTrigger asyncMailTriggerObject=new AsyncMailTrigger();
        asyncMailTriggerObject.senMail(populateMap());
    }

    private Map<String, String> populateMap() {
        Map<String,String> mailMap=new HashMap<String,String>();
        mailMap.put("body","A Ask2Sugar Article");
        return mailMap;
    }

  /*  @Async
    public void senMail(Map<String,String> properties){
        System.out.println("Trigger mail in a New Thread :: "+Thread.currentThread().getName());
        properties.forEach((K,V)->{
            System.out.println("key ::"+K+" Value ::"+V);
        });
    }*/
}
