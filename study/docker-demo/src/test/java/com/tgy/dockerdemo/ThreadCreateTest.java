package com.tgy.dockerdemo;

/**
 * @author DragonSwimDiving
 * @program docker-demo
 * @Date 2020-10-22 14:23
 **/

public class ThreadCreateTest {
    public static void main(String[] args) {
        new MyThread().start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId());
    }
}