package com.tgy.springbootshiro.sevive;

import com.tgy.springbootshiro.domain.User;

/**
 * @author tanggy
 * @date 2018/6/25
 */
public interface UserService {
    public User findByName(String name);

    public User findById(Integer id);
}
