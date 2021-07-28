package com.qunar;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author yang
 * 2021年07月13日 11:52:00
 */
public class 阻塞队列BlockQueue {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("put"+i);
                    queue.put("A"+ i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(1);
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

