package com.tgy.dockerdemo;

import java.util.concurrent.*;
/**
 * ArrayBlockingQueue
 * 基于数组实现，在ArrayBlockingQueue内部，维护了一个定长数组，以便缓存队列中的数据对象，这是一个常用的阻塞队列，
 * 除了一个定长数组外，ArrayBlockingQueue内部还保存着两个整形变量，分别标识着队列的头部和尾部在数组中的位置。
 * 一段代码来验证一下：
 * @author DragonSwimDiving
 * @program docker-demo
 * @Date 2020-10-22 14:49
 **/

public class MyTestMap {
    // 定义阻塞队列大小
    private static final int maxSize = 5;
    public static void main(String[] args){
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(maxSize);
        new Thread(new Productor(queue)).start();
        new Thread(new Customer(queue)).start();
    }
}

class Customer implements Runnable {
    private BlockingQueue<Integer> queue;
    Customer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        this.cusume();
    }

    private void cusume() {
        while (true) {
            try {
                int count = (int) queue.take();
                System.out.println("customer正在消费第" + count + "个商品===");
                // 只是为了方便观察输出结果
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Productor implements Runnable {
    private BlockingQueue<Integer> queue;
    private int count = 1;
    Productor(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        this.product();
    }
    private void product() {
        while (true) {
            try {
                queue.put(count);
                System.out.println("生产者正在生产第" + count + "个商品");
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
