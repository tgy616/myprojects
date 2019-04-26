package com.tgy.springbootstart.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/**
 * @author tanggy
 * @date 2018/6/28
 */
public class HelloApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments arg) throws Exception {
        System.out.println("ApplicationRunner。。。arg。。。");
    }
}
