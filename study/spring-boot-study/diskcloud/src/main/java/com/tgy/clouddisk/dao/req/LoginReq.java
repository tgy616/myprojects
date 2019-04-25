package com.tgy.clouddisk.dao.req;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author tanggy
 * @date 2018/11/1
 */
public class LoginReq {
    @NotNull
    @Size(min = 5, max = 16)
    private String username;

    @NotNull
    @Size(min = 5, max = 16)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginReq{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
