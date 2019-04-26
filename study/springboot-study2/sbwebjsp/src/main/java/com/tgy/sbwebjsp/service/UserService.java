package com.tgy.sbwebjsp.service;

import com.tgy.sbwebjsp.mapper.UserMapper;
import com.tgy.sbwebjsp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tanggy
 * @date 2018/10/31
 */
@Service("userService")
public class UserService {
    @Autowired
    private UserMapper dao;

    public UserService() {
    }

    public void createUser(User user) throws Exception {
        Boolean found = this.findUser(user.getUsername());
        if (!found) {
            this.dao.createUser(user);
        } else {
            throw new RuntimeException();
        }
    }

    public String checkUser(User user) throws Exception {
        return this.dao.checkUser(user);
    }

    public int findUserID(String username) throws Exception {
        return this.dao.findUser(username);
    }

    public boolean findUser(String username) throws Exception {
        Integer found = this.dao.findUser(username);
        return found != null && found >= 1;
    }

    public int isVip(String user_name) throws Exception {
        return this.dao.isVip(user_name);
    }
}
