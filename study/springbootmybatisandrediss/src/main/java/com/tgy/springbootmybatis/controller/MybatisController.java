package com.tgy.springbootmybatis.controller;

import com.tgy.springbootmybatis.entity.User;
import com.tgy.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MybatisController {

    @Autowired
    private UserService userService;



    @RequestMapping("/findAll")
    @Cacheable(value = "findAll")
    public List<User> findAll(){
        System.out.println("如果第二次没有打印此文字，说明缓存存在了，没有执行此方法！！！");
        List<User> list = userService.findAll();
        return list;
    }

}
