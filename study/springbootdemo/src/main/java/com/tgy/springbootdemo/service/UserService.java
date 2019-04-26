package com.tgy.springbootdemo.service;

import com.tgy.springbootdemo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author tanggy
 * @date 2018/5/9
 */
@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createUser(Integer id,String name, Integer age) {
        System.out.println("creatUser");
        jdbcTemplate.update("insert into users values(?,?,?);",id,name, age);
        System.out.println("创建用户成功！！");
    }

}
