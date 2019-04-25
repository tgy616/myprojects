package com.tgy.springbootredisandrediss.entity;

/**
 * @author tanggy
 * @date 2018/5/28
 */
public class User {
    private int id;
    private String  name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
