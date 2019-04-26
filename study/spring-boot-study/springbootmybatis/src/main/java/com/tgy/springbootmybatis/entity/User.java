package com.tgy.springbootmybatis.entity;

/**
 * entity
 *
 * @author DragonSwimDiving
 * @program springbootmybatis
 * @date 2019-04-26 11:01
 **/
public class User {
    private String name;
    private Integer age;
    private String description;
    private Integer height;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
