package com.qunar;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yang
 * 2021年05月24日 10:05:00
 */
public class 线程池异常 {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(7);
        try{
            for (int i = 0; i < 10; i++) {
                final int tempnum = i;
                executorService.execute(()->{
                    if ( tempnum <5) {
                        Object object = null;
                        System.out.print("result## "+object.toString());
                    }
                    System.out.println(tempnum);

                });
            }
        }catch ( Exception e){
            System.out.println(e);
        }finally {
            executorService.shutdown();
        }
    }
}
