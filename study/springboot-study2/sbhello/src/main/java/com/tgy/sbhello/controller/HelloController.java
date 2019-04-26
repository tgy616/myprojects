package com.tgy.sbhello.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanggy
 * @date 2018/6/13
 */
@RestController
public class HelloController {
    @Value("${person.last-name}")
    private String name;

    @RequestMapping("/hello")
    public String sayHello(){

        return "hello ,学习的世界！！！"+name;
    }
}
