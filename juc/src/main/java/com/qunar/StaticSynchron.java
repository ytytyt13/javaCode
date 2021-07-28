package com.qunar;

import java.util.concurrent.TimeUnit;

/**
 * @author yang
 * @Description TODO
 * @createTime 2020年11月11日 18:26:00
 */
public class StaticSynchron {
    public static void main
            (String[] args) {
        Phone phone = new Phone();

        new Thread(()-> phone.method1()).start();
        new Thread(()-> phone.method2()).start();
        new Thread(()-> phone.method3()).start();

    }
}

class Phone {
    String s="";

    public synchronized static void method1() {
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("mehod1");
            //HashMap;
            //ConcurrentHashMap
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized  void method2() {
        System.out.println("method2");
    }

    public void method3() {
        synchronized (s) {
            System.out.println("method3");
        }
    }
}

