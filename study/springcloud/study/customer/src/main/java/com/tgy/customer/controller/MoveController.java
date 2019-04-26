package com.tgy.customer.controller;


import com.tgy.customer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author tanggy
 * @date 2018/11/28
 */
@RestController
public class MoveController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/move/{id}")
    public User findById(@PathVariable Long id){
      return  restTemplate.getForObject("http://localhost:7900/findById/"+id,User.class);
    }

}
