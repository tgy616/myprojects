package com.tgy.springbootstart.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author tanggy
 * @date 2018/6/28
 */
@Component
public class HelloApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {


    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ApplicationContextInitializer..initialize..."+applicationContext);

    }
}
