package com.tgy.springbootdemo.dao;

import com.tgy.springbootdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author tanggy
 * @date 2018/5/9
 */
public interface UserDao extends JpaRepository<User, Integer> {
}

