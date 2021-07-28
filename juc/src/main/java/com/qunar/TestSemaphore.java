package com.qunar;

import java.util.concurrent.Semaphore;

/**
 * @author yang
 * @Description TODO
 * @createTime 2020年11月13日 21:55:00
 */
public class TestSemaphore {
    public static void main(String[] args) {


        Semaphore semaphore = new Semaphore(4);
        for (int i = 0; i < 7; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("q");
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}

/*
线程转换
JMM
vola
thread
runable
faturetask
synchronized
AQS
ReentrantLock
countDownLatch
cyclebarrir
semaphore
readwriteLock
blockqueue
线程池
lamdba
流式计算
hashmap
currenthashmap
threadlocal

* */