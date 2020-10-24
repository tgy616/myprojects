package com.tgy.dockerdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DragonSwimDiving
 * @program docker-demo
 * @Date 2020-09-29 16:55
 **/

public class TestOffen {
    public static void main(String[] args) {
        List<Integer> list0 = new ArrayList<Integer>();
        long start0 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list0.add(i);
        }
        System.out.println(System.currentTimeMillis() - start0);
        long start1 = System.currentTimeMillis();
        List<Integer> list1 = new ArrayList<Integer>();
        for (int i = 10000000; i < 20000000; i++) {
            list1.add(i);
        }
        System.out.println(System.currentTimeMillis() - start1);
    }
}
