package com.qunar;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yang
 * @Description TODO
 * @createTime 2020年11月11日 15:32:00
 */
public class 线程等待唤醒例子 {

    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                airConditioner.increment();
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    airConditioner.decrement();
                }
            }
        }, "B").start();
    }
}

class AirConditioner {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    public void increment() {

        lock.lock();
        try{
            while(number!=0){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"生产"+number);
        }finally {
            condition.signalAll();
        }
        lock.unlock();
    }


    public void decrement() {
        lock.lock();
        try{
            while(number ==0){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"消耗"+number);
        }finally {
            condition.signalAll();
        }
        lock.unlock();
    }
}
