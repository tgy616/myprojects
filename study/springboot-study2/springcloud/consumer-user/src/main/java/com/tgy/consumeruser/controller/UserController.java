package com.tgy.consumeruser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author tanggy
 * @date 2018/10/8
 */
@RestController
public class UserController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/buy")
    public String buyTicker(String name){
        String s = restTemplate.getForObject("http://PROVIDER-TICKET/ticket", String.class);
        return name+"购买了"+s;
    }
}
