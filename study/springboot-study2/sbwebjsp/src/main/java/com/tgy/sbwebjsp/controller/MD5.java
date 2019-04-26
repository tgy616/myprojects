package com.tgy.sbwebjsp.controller;

import com.tgy.sbwebjsp.util.MD5Mapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanggy
 * @date 2018/10/31
 */
@RestController
public class MD5 {
    public MD5() {
    }

    @RequestMapping({"/MD5test"})
    public String dosm(String MD5) {
        System.out.println(MD5);
        return MD5Mapper.MAP.containsKey(MD5) ? "{'fast':'true'}" : "{'fast':'false'}";
    }
}
