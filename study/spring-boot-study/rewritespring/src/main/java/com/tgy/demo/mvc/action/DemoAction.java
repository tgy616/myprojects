package com.tgy.demo.mvc.action;

import com.tgy.demo.service.IDemoService;
import com.tgy.mvcframework.annotation.GYAutowired;
import com.tgy.mvcframework.annotation.GYController;
import com.tgy.mvcframework.annotation.GYRequestMapping;
import com.tgy.mvcframework.annotation.GYRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author DragonSwimDiving
 * @program rewritespring
 * @Date 2019-06-24 17:09
 **/
@GYController
@GYRequestMapping("/demo")
public class DemoAction {
    @GYAutowired private IDemoService demoService;

    @GYRequestMapping("/query.json")
    public void query(HttpServletRequest req, HttpServletResponse resp,
                      @GYRequestParam("name")String name){
        String result=demoService.get(name);
        try {
            resp.getWriter().write(result);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @GYRequestMapping("/add.jsopn")
    public void add(HttpServletRequest req, HttpServletResponse resp,
                    @GYRequestParam("a")Integer a, @GYRequestParam("b")Integer b){
        try {
            resp.getWriter().write(a+"+"+b+"="+(a+b));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @GYRequestMapping("/remove.jsopn")
    public void add(HttpServletRequest req, HttpServletResponse resp,
                    @GYRequestParam("id") Integer id) {
    }
}
