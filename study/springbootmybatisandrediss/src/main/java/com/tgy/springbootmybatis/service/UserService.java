package com.tgy.springbootmybatis.service;

import com.tgy.springbootmybatis.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tanggy
 * @date 2018/6/12
 */
@Service
public interface UserService {
    public List<User> findAll();
}
