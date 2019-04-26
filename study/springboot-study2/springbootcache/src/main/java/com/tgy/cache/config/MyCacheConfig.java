package com.tgy.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;


/**
 * @author tanggy
 * @date 2018/7/4
 */
@Configuration
public class MyCacheConfig {

    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator(){
       return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return method.getName()+"["+ Arrays.asList(params).toString()+"]";
            }
        };

    }

}
