package com.qunar;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yang
 * 2021年07月09日 16:31:00
 */
public class ReentrantLock响应中断 {

    private static ReentrantLock lock1;
    public static void main(String[] args) {
        lock1=new ReentrantLock();

        Thread a = new Thread(() -> {
            try {
                System.out.println("开始运行");
                lock1.lock();
                System.out.println("获取锁成功");
                while(true) {
                    System.out.println("step1");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
            }
        }, "A");

        a.start();

        a.interrupt();


    }
}
