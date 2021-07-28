package com.qunar;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author yang
 * 2021年03月19日 15:31:00
 */
public class 阻塞队列SynchronousQueue {

    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> synQ = new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println("放入前");
                synQ.put("aaa");
                System.out.println("放入后");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();


        new Thread(()->{
            try {
                System.out.println("c放入前");
                synQ.put("ccc");
                System.out.println("c放入后");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"c").start();


        Thread.sleep(5000);

        new Thread(()->{
            try {
                System.out.println("读取前");
                synQ.take();
                System.out.println("读取后");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();

    }
}
