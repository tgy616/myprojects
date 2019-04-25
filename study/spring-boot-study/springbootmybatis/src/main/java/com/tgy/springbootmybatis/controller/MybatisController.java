package com.tgy.springbootmybatis.controller;

import com.tgy.springbootmybatis.entity.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisController {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @RequestMapping("/user/{id}")
    public User user(@PathVariable int id) {

        User user = sqlSessionTemplate.selectOne("com.tgy.springbootmybatis.mapper.UserMapper.selectOneUser", id);

        return user;

    }

}
