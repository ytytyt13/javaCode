package com.qunar;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author yang
 * @Description TODO
 * @createTime 2020年11月13日 20:13:00
 */
public class Callable接口 {
    public static void main(String[] args) {

        new Thread(new Mythread2()).run();
        new Thread(new Mythread2()).run();
        new Thread(new Mythread2()).run();
        FutureTask futureTask = new FutureTask(new Mythread1());

        System.out.println("a");
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}


class Mythread1 implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("hello come in");
        TimeUnit.SECONDS.sleep(100);
        return "CALL";
    }
}

class Mythread2 implements Runnable {
    //只能捕获RuntimeException，不能够捕获其他异常
    @Override
    public void run() throws RuntimeException {
        try {
            Thread.sleep(3000);
            System.out.println("2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}