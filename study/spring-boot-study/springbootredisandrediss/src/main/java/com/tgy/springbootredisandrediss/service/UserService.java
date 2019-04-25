package com.tgy.springbootredisandrediss.service;

import com.tgy.springbootredisandrediss.entity.User;

import java.util.List;

/**
 * @author tanggy
 * @date 2018/6/12
 */
public interface UserService {
    public List<User> findAll();
}
