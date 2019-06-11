package com.tgy.springbootproperty.conroller;

import com.tgy.springbootproperty.domin.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DragonSwimDiving
 * @program springbootproperty
 * @Date 2019-06-06 17:58
 **/
@RestController
public class PersonController {

    @Autowired
    @Qualifier("person")
    private Person person;

    @GetMapping("/person/test")
    public Person test(){
        return person;
    }

}
