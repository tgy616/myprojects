package com.tgy.springbootmybatis.mapper;

import com.tgy.springbootmybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public List<User> findAll();
}