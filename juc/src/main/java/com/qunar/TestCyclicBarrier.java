package com.qunar;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author yang
 * @Description TODO
 * @createTime 2020年11月13日 21:35:00
 */
public class TestCyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier aaa = new CyclicBarrier(100, new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("aaa");
            }
        });
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("bbb");
                        aaa.await();
                        System.out.println("ccc");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        //System.out.println("ddd");
    }
}
