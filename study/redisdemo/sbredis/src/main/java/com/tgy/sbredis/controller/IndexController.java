package com.tgy.sbredis.controller;

import com.tgy.sbredis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanggy
 * @date 2018/5/15
 */
@RestController
public class IndexController {
    @Autowired
    private RedisService redisService;

    @RequestMapping("/setString")
    public String setString(String key ,String value){
       redisService.setString(key,value);
       return "set redis sucess";
    }

    @RequestMapping("/getString")
    public String getString(String key){
        return redisService.getStringKey(key);
    }

    @RequestMapping("/setList")
    public String setList(String key){
        List<String> listString = new ArrayList<>();
        listString.add("cc");
        listString.add("tgy");
        listString.add("test");
        redisService.setList(key,listString);
        return "set redis sucess";
    }
}
