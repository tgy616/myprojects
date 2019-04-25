package com.tgy.clouddisk.service.Impl;

import com.tgy.clouddisk.entity.User;
import com.tgy.clouddisk.entity.UserDTO;
import com.tgy.clouddisk.mapper.UserMapper;
import com.tgy.clouddisk.service.UserService;
import com.tgy.clouddisk.util.JwtUtil;
import com.tgy.clouddisk.util.object.DTOConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tanggy
 * @date 2018/11/1
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
//    @Autowired
//    private DTOConvertUtil convertor;

    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public boolean checkUsername(String username) {
        User user = userMapper.selectByUsername(username);
        if (user != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPassword(String username, String password) {
        User user = userMapper.selectByPassword(username, password);
        if (user != null) {
            return true;
        }
        return false;
    }

    @Override
    public String login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            System.out.println("用户名不存在");
        } else if (user.getPassword().equals(password)) {
            return JwtUtil.generateToken(username);
        } else {
            System.out.println("密码错误");
        }
        return "登陆失败";
    }

    @Override
    public int changePass(String username, String password) {
        int userId = getUserByUsername(username).getUserId();
        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            return null;
        } else {
            //return convertor.convertToDTO(user);
            //TODO 重新写
            return null;
        }
    }

    @Override
    public UserDTO getUserByUserId(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            return null;
        } else {
            //return convertor.convertToDTO(user);
            //TODO 重新写
            return null;
        }
    }

    @Override
    public int deleteUser(String username, String password) {
        User user = userMapper.selectByUsername(username);
        return userMapper.deleteByPrimaryKey(user.getUserId());
    }

    @Override
    public int updateUser(User user) {
        int userId = getUserByUsername(user.getUsername()).getUserId();
        user.setUserId(userId);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int selectRowCount() {
        return userMapper.selectRowCount();
    }
}