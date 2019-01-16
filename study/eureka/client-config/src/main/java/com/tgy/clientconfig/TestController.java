package com.tgy.clientconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanggy
 * @date 2019/1/16
 */
@RestController
public class TestController {
    @Value("${userName}")
    private String userName;

    @RequestMapping("/getUserName")
    public String getUserName() {
        return userName;
    }
}
