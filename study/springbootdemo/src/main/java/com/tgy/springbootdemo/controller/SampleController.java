package com.tgy.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @author tanggy
 * @date 2018/5/9
 */
@Controller
public class SampleController {
    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "hello World!";
    }

    @RequestMapping("/hello")
    @ResponseBody
    String home2(){
        return "hello World!哈哈哈哈哈！";
    }

//    public static void main(String[] args) {
//        SpringApplication.run(SampleController.class,args);
//    }

}
