package com.tgy.demo.service.impl;

import com.tgy.demo.service.IDemoService;
import com.tgy.mvcframework.annotation.GYService;

/**
 * @author DragonSwimDiving
 * @program rewritespring
 * @Date 2019-06-24 17:11
 **/
@GYService
public class DemoService implements IDemoService {
    public String get(String name) {
        return "My name is "+name+",from service";
    }
}
