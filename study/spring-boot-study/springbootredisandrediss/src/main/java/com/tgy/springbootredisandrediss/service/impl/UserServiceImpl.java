package com.tgy.springbootredisandrediss.service.impl;

import com.tgy.springbootredisandrediss.entity.User;
import com.tgy.springbootredisandrediss.dao.UserMapper;
import com.tgy.springbootredisandrediss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tanggy
 * @date 2018/6/12
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        System.out.println(userMapper.findAll());
        List<User> list = userMapper.findAll();
        System.out.println(list.toString());
        return list;
    }
}
