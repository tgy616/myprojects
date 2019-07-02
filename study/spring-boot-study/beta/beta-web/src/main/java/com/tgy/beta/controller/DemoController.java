package com.tgy.beta.controller;

import com.tgy.beta.biz.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * test
 *
 * @author DragonSwimDiving
 * @program beta
 * @Date 2019-07-01 17:38
 **/
@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoService demoService;

    @GetMapping("/test")
    public String test(Integer id) {
        return demoService.test(id);
    }
}
