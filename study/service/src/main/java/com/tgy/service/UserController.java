package com.tgy.service;

import com.tgy.service.entity.User;
import com.tgy.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanggy
 * @date 2018/11/28
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable Long id){
        return userRepository.findOne(id);

    }

}
