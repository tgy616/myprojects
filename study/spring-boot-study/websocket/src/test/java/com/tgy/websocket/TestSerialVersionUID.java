package com.tgy.websocket;

import java.io.Serializable;

/**
 * 测试idea自动生成serialVersionUID
 *
 * @author DragonSwimDiving
 * @program websocket.demo
 * @Date 2019-04-29 15:11
 **/

public class TestSerialVersionUID implements Serializable {

    private static final long serialVersionUID = 5787864485490126252L;
    private String course;
    private String scoure;


    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getScoure() {
        return scoure;
    }

    public void setScoure(String scoure) {
        this.scoure = scoure;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
