package com.tgy.websocket;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda表达式 Test
 *
 * @author DragonSwimDiving
 * @program websocket.demo
 * @Date 2019-05-20 16:27
 **/

public class LambdaTest {

    public static void main(String[] args) {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);

        // 以前的循环方式
        for (String player : players) {
            System.out.println("for 循环："+player + "; ");
        }
        System.out.println("---------------------------------------------------------------");
        // 使用 lambda 表达式以及函数操作(functional operation)
        players.forEach((player) -> System.out.println("lambda 表达式："+player + "; "));
        System.out.println("---------------------------------------------------------------");
        // 在 Java 8 中使用双冒号操作符(double colon operator)
        players.forEach(System.out::println);
    }

}
