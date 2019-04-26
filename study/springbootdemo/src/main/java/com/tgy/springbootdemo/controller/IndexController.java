package com.tgy.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author tanggy
 * @date 2018/5/9
 */
//@RestController
@Controller
public class IndexController {
    @RequestMapping("/indexController")
    public String indexController(Map<String,Object> result){
        System.out.println("indexController.......index");
        result.put("name","TGY");
        result.put("sex",1);
        List<String> list = new ArrayList<String>();
        list.add("zhangsan");
        list.add("lisi");
        result.put("userlist",list);
        return "index";
    }
}
