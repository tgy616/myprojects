package com.tgy.springbootshiro.mapper;

import com.tgy.springbootshiro.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author tanggy
 * @date 2018/6/25
 */
@Mapper
public interface UserMapper {

    public User findByName(String name);

    public User findById(Integer id);
}
