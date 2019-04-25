package com.tgy.springbootredisandrediss.dao;

import com.tgy.springbootredisandrediss.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author tanggy
 * @date 2018/6/12
 */
@Mapper
public interface UserMapper {
    List<User> findAll();
}
