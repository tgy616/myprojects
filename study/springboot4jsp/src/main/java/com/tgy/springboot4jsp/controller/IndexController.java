package com.tgy.springboot4jsp.controller;

import com.tgy.springboot4jsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tanggy
 * @date 2018/5/9
 */
@Controller
public class IndexController {
    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public String index(){
        return "index";
    }
    @ResponseBody
    @RequestMapping("/add")
    public String add(Integer id,String name, Integer age) {
        userService.add(id,name, age);
        return "succes";
    }

}
