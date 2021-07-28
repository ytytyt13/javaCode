package com.qunar;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author yang
 * @Description TODO
 * @createTime 2020年11月17日 16:31:00
 */
public class 线程池 {
    public static void main(String[] args) throws Exception {
        Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Executors.newFixedThreadPool(7);
        try{
            for (int i = 0; i < 10; i++) {
                final int tempnum = i;
                executorService.execute(()->{
                    if ( tempnum <5) {
                        //int a =10/0;
                    }
                    System.out.println(tempnum);

                });
            }
        }catch ( Exception e){
            System.out.println(e);
        }finally {
            executorService.shutdown();
        }


        System.out.println("------------------------------------");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
                10,
                5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(6),
                new ThreadPoolExecutor.AbortPolicy());

        MyCallable myCallable = new MyCallable();
        MyRunnable myRunnable = new MyRunnable();
        for (int i = 0; i < 8; i++) {

            Future<String> submit = threadPoolExecutor.submit(myCallable);
            System.out.println("myCallable:"+submit.get());
        }

        for (int i = 0; i < 8; i++) {
            Future<?> submit = threadPoolExecutor.submit(myRunnable);
        }
        //AtomicMarkableReference;
        //AtomicStampedReference;
        threadPoolExecutor.shutdown();


    }
}

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        int a= 1/0;
        return Thread.currentThread().getName();
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("runnable:" + Thread.currentThread().getName());
    }
}
