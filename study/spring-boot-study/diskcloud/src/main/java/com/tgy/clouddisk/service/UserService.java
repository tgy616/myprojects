package com.tgy.clouddisk.service;

import com.tgy.clouddisk.entity.User;
import com.tgy.clouddisk.entity.UserDTO;

/**
 * @author tanggy
 * @date 2018/11/1
 */
public interface UserService {
    int insertUser(User user);

    boolean checkUsername(String username);

    boolean checkPassword(String username, String password);

    int changePass(String username, String password);

    UserDTO getUserByUserId(Integer userId);

    UserDTO getUserByUsername(String username);

    int deleteUser(String username, String password);

    int updateUser(User user);

    int selectRowCount();

    String login(String username, String password);
}
