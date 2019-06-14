package com.tgy.spingboottest.controller;

import com.tgy.spingboottest.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DragonSwimDiving
 * @program spingboottest
 * @Date 2019-06-14 14:59
 **/
@RestController
public class PersonController {
    @Autowired
    private Person person;

    @GetMapping("/")
    public Person person(){
        return person;
    }
}
