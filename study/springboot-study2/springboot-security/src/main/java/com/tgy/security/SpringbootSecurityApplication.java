package com.tgy.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  1、引入Spring Security模块
 *  2、编写Spring Security的配置类；
 *    @EnableWebSecurity  extends WebSecurityConfigurerAdapter
 *  3、控制请求访问权限
 */
@SpringBootApplication
public class SpringbootSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSecurityApplication.class, args);
    }
}
