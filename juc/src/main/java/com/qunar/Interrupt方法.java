package com.qunar;

/**
 * @author yang
 * 2021年01月13日 21:41:00
 */
public class Interrupt方法 {
    public static void main(String[] args) {
        /*
        * thread中的interrupt(),interruptted(),isInterrupted()方法
        * */

        Thread thread = new Thread(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
        //}
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
            System.out.println(Thread.interrupted());
            System.out.println(Thread.interrupted());
        }, "a");

        thread.start();
        thread.interrupt();
//        System.out.println("当前线程是否被中断:"+Thread.interrupted());
//        System.out.println("当前线程是否被中断:"+Thread.interrupted());
//        System.out.println("当前线程是否被中断:"+Thread.interrupted());
//        System.out.println("当前线程是否被中断:"+Thread.interrupted());
//        System.out.println("isInterrupted："+thread.isInterrupted());




    }
}


