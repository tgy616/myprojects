package com.tgy.demospringboot.ddos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tanggy
 * @date 2018/10/26
 */
public class TestClass {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1000);
        DDOSTtrack mythread = new DDOSTtrack();
        Thread thread = new Thread(mythread);
        for (int i = 0; i < 10000; i++) {
            es.execute(thread);
        }

    }
}
