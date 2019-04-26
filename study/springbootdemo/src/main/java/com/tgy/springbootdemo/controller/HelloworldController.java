package com.tgy.springbootdemo.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tanggy
 * @date 2018/5/9
 */
//标识该接口全部返回json格式
@RestController
public class HelloworldController {

    @RequestMapping("/index")
    public String index(){
        return "success";
    }
    @RequestMapping("/getMap")
    public Map<String,Object> getMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("errorCode","200");
        result.put("errorMsg","成功");
        return result;
    }

//    public static void main(String[] args) {
//        //主函数springboot项目的运行入口
//        SpringApplication.run(HellworldController.class,args);
//    }
}
