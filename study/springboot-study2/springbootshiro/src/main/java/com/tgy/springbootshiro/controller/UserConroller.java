package com.tgy.springbootshiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tanggy
 * @date 2018/6/22
 */
@Controller
public class UserConroller {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {

        return "ok";
    }

    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(Model model) {
        model.addAttribute("name", "shiro");
        return "test";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        return "/user/add";
    }

    @RequestMapping("/update")
    public String update(Model model) {
        return "/user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin(Model model) {
        return "login";
    }

    @RequestMapping("/unAuth")
    public String unAuth(Model model) {
        return "unAuth";
    }

    @RequestMapping("/login")
    public String login(String name,String password,Model model) {
        //使用Shori编写认证操作
        //1、获取subject
        Subject subject = SecurityUtils.getSubject();
        //2、封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        //3、执行登录方法
        try {
            subject.login(token);
            //登录成功
            //调整到test页面
            return "redirect:/testThymeleaf";
        } catch (UnknownAccountException e) {
            //e.printStackTrace();
            //登录失败:用户名不存在
            model.addAttribute("msg", "用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException e) {
            //登录失败:密码错误
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }


}
