package com.tgy.springbootshiro.sevive.impl;

import com.tgy.springbootshiro.domain.User;
import com.tgy.springbootshiro.mapper.UserMapper;
import com.tgy.springbootshiro.sevive.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tanggy
 * @date 2018/6/25
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByName(String name) {

        return userMapper.findByName(name);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}
