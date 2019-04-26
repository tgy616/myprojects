package com.tgy.springbootdemo.controller;

import com.tgy.springbootdemo.dao.UserDao;
import com.tgy.springbootdemo.entity.User;
import com.tgy.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanggy
 * @date 2018/5/9
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @RequestMapping("/createUser")
    public String createUser(Integer id,String name, Integer age) {
        userService.createUser(id, name,age);
        return "success";
    }
    @RequestMapping("/getUser")
    public User getUser(Integer id){
        return userDao.findOne(id);
    }

}
