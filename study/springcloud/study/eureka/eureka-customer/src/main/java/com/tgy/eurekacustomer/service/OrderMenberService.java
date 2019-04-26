package com.tgy.eurekacustomer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author tanggy
 * @date 2018/12/4
 */
@Service
public class OrderMenberService {

    @Autowired
    private RestTemplate restTemplate;

    public List<String> getOrderUserAll() {
        return restTemplate.getForObject("http://eureka-client/getAllInfo", List.class);
    }

}
