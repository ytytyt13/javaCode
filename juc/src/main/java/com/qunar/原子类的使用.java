package com.qunar;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yang
 * 2021年05月19日 11:17:00
 */
public class 原子类的使用 {

    private static final int THREADS_CONUT = 20;
    public static AtomicInteger count = new AtomicInteger(0);

    public static void increase() {
        count.incrementAndGet();
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_CONUT];
        for (int i = 0; i < THREADS_CONUT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        while(Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(count);
    }
}
