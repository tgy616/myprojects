package com.tgy.clouddisk.controller;

import com.tgy.clouddisk.dao.req.LoginReq;
import com.tgy.clouddisk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
/**
 * @author tanggy
 * @date 2018/11/1
 */
@RestController
@RequestMapping(produces = "application/json", consumes = "application/json")
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * POST login/authentication <br/>
     * 检查用户名与密码，若用户名与密码匹配，返回一个该用户的Token，
     * 该Token可用于访问该用户的资源
     */
    @RequestMapping(value = "/authentication", method = RequestMethod.POST)
    public Map<String, Object> authentication(@RequestBody @Valid LoginReq req) {
        String token = userService.login(req.getUsername(), req.getPassword());

        Map<String, Object> result = new HashMap<>();
        if (token.equals("登陆失败"))
            result.put("status_code", 401);
        result.put("token", token);
        return result;
    }
}