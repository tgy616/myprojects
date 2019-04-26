package com.tgy.deploy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author tanggy
 * @date 2018/10/8
 */
@Controller
public class HelloController {
    @GetMapping("/abc")
    public String hello(){
        return "hello";
    }
}
