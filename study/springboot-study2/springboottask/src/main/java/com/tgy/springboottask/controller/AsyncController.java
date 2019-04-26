package com.tgy.springboottask.controller;

import com.tgy.springboottask.server.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanggy
 * @date 2018/9/29
 */
@RestController
public class AsyncController {
    @Autowired
    private AsyncService asyncService;

    @GetMapping("/hello")
    public String hello(){
         asyncService.hello();
         return "success";
    }
}
