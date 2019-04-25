package com.tgy.springbootredisandrediss.controller;

import com.tgy.springbootredisandrediss.entity.User;
import com.tgy.springbootredisandrediss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tanggy
 * @date 2018/6/12
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll(){
        List<User> list = userService.findAll();
        return list;
    }
}
