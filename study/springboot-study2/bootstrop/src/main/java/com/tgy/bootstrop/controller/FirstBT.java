package com.tgy.bootstrop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author tanggy
 * @date 2018/11/8
 */
@Controller
public class FirstBT {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String first(Map<String,Object> map){
        map.put("msg", "Hello Thymeleaf");
        return "test.html";
    }
}
