package com.tgy.springbootcache.controller;

import com.tgy.springbootcache.entity.Person;
import com.tgy.springbootcache.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * TODO
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see
 * @since 2017.08.04
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @PostMapping("/save")
    public Person save(@RequestBody Person person) {

        repository.savePerson(person);

        return person;

    }


    @GetMapping("/get/{id}")
    public Person get(@PathVariable String id) {

        return repository.findPerson(id);

    }


}
