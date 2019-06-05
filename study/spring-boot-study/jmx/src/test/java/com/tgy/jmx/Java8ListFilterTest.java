package com.tgy.jmx;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * java8 list的filter
 *
 * @author DragonSwimDiving
 * @program jmx
 * @Date 2019-06-05 10:19
 **/

public class Java8ListFilterTest {
    public static void main(String[] args) {
        List<Integer> listOne = new ArrayList<>();
        listOne.add(1);
        listOne.add(3);
        listOne.add(5);
        listOne.add(7);
        List<Integer> listTwo = new ArrayList<>();
        listTwo.add(1);
        listTwo.add(2);
        listTwo.add(4);
        listTwo.add(6);
        listTwo.add(8);
        listOne.stream().forEach(Integer -> {
            System.out.println("listOne:" + Integer);
        });
        System.out.println("---------------------------------");
    /*    listOne.retainAll(listTwo);
        System.out.println("listOne和listTwo的交集："+listOne);
        List<Integer> even=listTwo.stream().filter(Integer->Integer!=listOne.get(0)).collect(Collectors.toList());
        System.out.println(even);*/

        //合并
        listOne.addAll(listTwo);
        System.out.println("listOne UNION ALL listTwo"+listOne);
        //单个数组去重
        System.out.println(listOne.stream().distinct().collect(Collectors.toList()));

    }
}
