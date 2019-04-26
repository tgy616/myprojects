package com.tgy.springbootmybatis.service.impl;

import com.tgy.springbootmybatis.entity.User;
import com.tgy.springbootmybatis.mapper.UserMapper;
import com.tgy.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tanggy
 * @date 2018/6/12
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAll() {
        List<User> list = userMapper.findAll();
        return list;
    }
}
