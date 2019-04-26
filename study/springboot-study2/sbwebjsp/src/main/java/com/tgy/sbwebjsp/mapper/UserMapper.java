package com.tgy.sbwebjsp.mapper;

import com.tgy.sbwebjsp.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author tanggy
 * @date 2018/10/31
 */
@Mapper
public interface UserMapper {
    @Insert({"INSERT INTO user(username,password,isvip) VALUES(#{username},#{password},#{isvip})"})
    void createUser(User user) throws Exception;

    @Select({"SELECT user.username FROM user WHERE username=#{username} AND password=#{password}"})
    String checkUser(User user) throws Exception;

    @Select({"SELECT user.id FROM user WHERE username=#{username}"})
    Integer findUser(String username) throws Exception;

    @Select({"SELECT isvip FROM user WHERE username=#{value}"})
    Integer isVip(String user_name) throws Exception;
}
