package com.qunar;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yang
 * @Description TODO
 * @createTime 2020年11月15日 15:34:00
 */

//当队列为空，获取队列中的元素，线程会阻塞
//当队列为满，向独列中添加元素，线程会阻塞
public class 阻塞队列 {
    public static void main(String[] args) throws InterruptedException {
        //add,remove返回异常
        ArrayBlockingQueue<Object> objects1 = new ArrayBlockingQueue<>(1);
        //objects1.remove();
        objects1.add(1);
        //objects1.add(2);

        //offer,poll返回空
        ArrayBlockingQueue<Object> objects2 = new ArrayBlockingQueue<>(1);
        System.out.println(objects2.poll());
        System.out.println(objects2.offer(1));
        System.out.println(objects2.offer(2));

        //put,take阻塞
        ArrayBlockingQueue<Object> objects3 = new ArrayBlockingQueue<>(1);
        //System.out.println(objects3.take());
        objects3.put(1);
        objects3.put(2);

        new SynchronousQueue<>();

        BlockingQueue<String> queue1 = new LinkedBlockingDeque<>(7);
        for (int i = 0; i < 10; i++) {
            //final int a = i;
            new Thread(()->{
                try {
                    //System.out.println(a);
                    queue1.put("a");
                    System.out.println("aaaaa");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(3);
        System.out.println("c");
        queue1.put("c");

//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
//                try {
//                    queue1.take();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
    }

    @Override
    public void setUncaughtExceptionHandler(UncaughtExceptionHandler eh) {
        super.setUncaughtExceptionHandler(eh);
    }
}


class un implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("异常未处理");
    }
}
