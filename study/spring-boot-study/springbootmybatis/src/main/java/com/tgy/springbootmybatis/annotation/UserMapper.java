package com.tgy.springbootmybatis.annotation;

import com.tgy.springbootmybatis.entity2.User;
import com.tgy.springbootmybatis.handler.DescriptionTypeHandler;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Results(value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age"),
            @Result(property = "description", column = "desc", typeHandler = DescriptionTypeHandler.class),
            @Result(property = "height", column = "height")
    })
    @Select("SELECT id,name,age,`desc`,height FROM user WHERE id = #{id}")
    User selectUser(int id);

}
