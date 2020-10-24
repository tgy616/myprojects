package com.tgy.springbootdocker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DragonSwimDiving
 * @program spring-boot-docker
 * @Date 2020-09-18 14:19
 **/

@RestController
@Slf4j
public class TestController {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        System.out.println("这是控制台日志！");
        log.info("这是输出到文件的日志");
        return   "HELLO-BUG！！！！！！！！！！";
    }
}
