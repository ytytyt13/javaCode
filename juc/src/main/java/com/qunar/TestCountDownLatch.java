package com.qunar;

import java.util.concurrent.CountDownLatch;

/**
 * @author yang
 * @Description TODO
 * @createTime 2020年11月13日 21:25:00
 */
public class TestCountDownLatch {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        for (int i = 0; i <8; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("run");
                    countDownLatch.countDown();
                }
            }).start();
        }
        try {
            countDownLatch.await();

            System.out.println("main");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
