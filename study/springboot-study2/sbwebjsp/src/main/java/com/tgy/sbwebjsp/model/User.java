package com.tgy.sbwebjsp.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author tanggy
 * @date 2018/10/31
 */
@Component("user")
@Scope("prototype")
public class User {
    private int id;
    private String password;
    private String username;
    private int isvip = 1;

    public User() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIsvip() {
        return this.isvip;
    }

    public void setIsvip(int isvip) {
        this.isvip = isvip;
    }
}
