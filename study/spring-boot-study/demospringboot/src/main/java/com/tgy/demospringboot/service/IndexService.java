package com.tgy.demospringboot.service;

import org.springframework.stereotype.Service;

/**
 * @author tanggy
 * @date 2018/5/16
 */
@Service
public class IndexService {

    public String showHello() {
        return "Hello World!";
    }
}
