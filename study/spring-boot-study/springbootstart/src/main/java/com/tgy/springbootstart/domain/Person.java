package com.tgy.springbootstart.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author DragonSwimDiving
 * @program springbootstart
 * @Date 2019-06-20 17:06
 **/
//@ConfigurationProperties(prefix = "person")
public class Person {
    private Long id;
    private String name;
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
