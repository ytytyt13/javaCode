package com.qunar;


import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * @author yang
 * 2021年01月14日 19:58:00
 */
public class Exchanger方法 {
    static class Producer extends Thread {
        private Exchanger<Integer> exchanger;
        private static int data = 0;

        Producer(String name, Exchanger<Integer> exchanger) {
            super("Producer-" + name);
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(1);
                data = 1;
                System.out.println(getName() + " 交换前:" + data);
                data = exchanger.exchange(data);
                System.out.println(getName() + " 交换后:" + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    static class Consumer extends Thread {
        private Exchanger<Integer> exchanger;
        private static int data = 0;

        Consumer(String name, Exchanger<Integer> exchanger) {
            super("Consumer-" + name);
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            data = 0;
            System.out.println(getName() + " 交换前:" + data);
            try {
                TimeUnit.SECONDS.sleep(1);
                data = exchanger.exchange(data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " 交换后:" + data);

        }
    }

    static class Consumer1 extends Thread {
        private Exchanger<Integer> exchanger;
        private static int data = 0;

        Consumer1(String name, Exchanger<Integer> exchanger) {
            super("Consumer1-" + name);
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            data = 0;
            System.out.println(getName() + " 交换前:" + data);
            try {
                data = exchanger.exchange(data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " 交换后:" + data);

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Exchanger<Integer> exchanger = new Exchanger<Integer>();
        new Producer("", exchanger).start();
        new Consumer("", exchanger).start();
        new Consumer1("", exchanger).start();
        //TimeUnit.SECONDS.sleep(7);
        //System.exit(-1);
    }

}
