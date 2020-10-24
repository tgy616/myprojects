package com.tgy.dockerdemo;

/**
 * 线程池方式创建：实现Runnable接口这种方式更受欢迎，因为这不需要继承Thread类。在应用设计中已经继承了别的对象的情况下，
 * 这需要多继承（而Java不支持多继承，但可以多实现啊），只能实现接口。同时，线程池也是非常高效的，很容易实现和使用。
 * 实际开发中，阿里巴巴开发插件一直提倡使用线程池创建线程
 * @author DragonSwimDiving
 * @program docker-demo
 * @Date 2020-10-22 14:24
 **/

public class RunableCreateTest {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId());
    }
}