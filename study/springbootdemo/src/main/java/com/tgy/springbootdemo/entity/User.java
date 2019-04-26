package com.tgy.springbootdemo.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 * @author tanggy
 * @date 2018/5/9
 */
@Entity(name = "users")
public class User {
    @Id
    //@GeneratedValue
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer age;
    // ..get/set方法

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
