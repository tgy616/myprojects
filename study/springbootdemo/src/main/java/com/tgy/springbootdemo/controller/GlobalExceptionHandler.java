package com.tgy.springbootdemo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局捕获异常类 ---捕获所有异常
 * @author tanggy
 * @date 2018/5/9
 */
//全局捕获异常类
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    //如果返回json格式 @ResponseBody 返回页面 返回string类型 类型结果指定404页面
    @ResponseBody
    public Map<String,Object> resultError(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("errorCode","500");
        result.put("errorMsg","系统错误");
        return result;
    }
}
