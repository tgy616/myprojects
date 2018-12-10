package com.tgy.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanggy
 * @date 2018/12/3
 */
@RestController
public class ClientController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/getAllInfo")
    public List<String> getAllInfo(){
        ArrayList<String> list = new ArrayList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("端口号:"+serverPort);

        return list;
    }
    @RequestMapping("/getClientServiceApi")
    public String getClientServiceApi(){
        return "this is eureka-client process！！！";
    }
}
