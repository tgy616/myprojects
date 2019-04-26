package com.tgy.springboottask.server;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author tanggy
 * @date 2018/9/29
 */
@Service
public class AsyncService {
    //告诉spring这是一个异步方法
    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据中……");
    }
}
