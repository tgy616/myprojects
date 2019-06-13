package com.tgy.spingboottest.domain;

/**
 * @author DragonSwimDiving
 * @program spingboottest
 * @Date 2019-06-12 16:20
 **/

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
