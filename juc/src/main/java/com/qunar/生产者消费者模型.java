package com.qunar;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author yang
 * 2021年05月18日 12:46:00
 */
public class 生产者消费者模型 {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList<>();

        new Producer(linkedList).start();
        new Consumer(linkedList).start();
    }
}




class Consumer extends Thread{

    private LinkedList<String> storage;//仓库

    public Consumer(LinkedList<String> storage) {
        this.storage = storage;
    }
    @Override
    public void run(){
        while(true) {
            synchronized (storage) {
                while (storage.isEmpty()) {
                    try {
                        System.out.println("队列为空,进入休眠");
                        storage.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String first = storage.pollFirst();
                System.out.println("消费者消费第" + first + "消息");
                storage.notify();

//                try {
//                    Thread.sleep(1100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }
}

class Producer extends Thread implements Thread.UncaughtExceptionHandler {

    private LinkedList<String> storage;//生产者仓库
    public Producer(LinkedList<String> storage) {
        this.storage = storage;
    }
    @Override
    public void run(){
        int size = 0;
        while(true) {
            synchronized (storage) {
                while (storage.size() == 5) {
                    try {
                        System.out.println("队列满了,进入休眠");
                        storage.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                size++;
                String msg = "生产者生产第" + size + "条消息";
                System.out.println(msg);
                storage.addLast(size + "条");
                storage.notify();

                int[] arr = {1};
                System.out.println(arr[2]);

//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(e);
        System.out.println("定义异常处理方");
    }
}

