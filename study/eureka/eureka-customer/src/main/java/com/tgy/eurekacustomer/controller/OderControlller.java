package com.tgy.eurekacustomer.controller;

import com.tgy.eurekacustomer.service.OrderMenberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tanggy
 * @date 2018/12/4
 */
@RestController
public class OderControlller {
    @Autowired
    private OrderMenberService service;

    @RequestMapping("/getOrderUserAll")
    public List<String> getOrderUserAll() {
        System.out.println("订单服务开始调用会员服务了！！！");
        return service.getOrderUserAll();
    }

    @RequestMapping("/getCustomerServiceApi")
    public String getCustomerServiceApi(){
        return "this is eureka-customer process！！！";
    }
}
