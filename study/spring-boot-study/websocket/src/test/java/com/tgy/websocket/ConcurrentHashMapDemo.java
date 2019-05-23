package com.tgy.websocket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap Test
 *
 * @author DragonSwimDiving
 * @program websocket.demo
 * @Date 2019-05-05 17:37
 **/

public class ConcurrentHashMapDemo {
    private Map<Integer,Integer> cache =new ConcurrentHashMap<>(15);

/*    public static void main(String[]args){
        ConcurrentHashMapDemo ch =    new ConcurrentHashMapDemo();
        System.out.println(ch.fibonaacci(80));
    }

    public int fibonaacci(Integer i){
        if(i==0||i ==1) {
            return i;
        }

        return cache.computeIfAbsent(i,(key) -> {
            System.out.println("fibonaacci : "+key);
            return fibonaacci(key -1)+fibonaacci(key - 2);
        });

    }*/
    private static Map<String,String> map =new ConcurrentHashMap<>(15);
    public static void main(String[] args) {
        String s = map.computeIfAbsent("AaAa",
                (String key) -> {
                    map.put("BBBB", "value");
                    return "value";
                });
        System.out.println(s);
    }
}
