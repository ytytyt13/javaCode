package com.qunar;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yang
 * @Description TODO
 * @createTime 2020年11月11日 14:20:00
 */
public class RerntrantLock买票 {
    public static void main(String[] args) {

        new ReentrantLock();

        TicketRerntrantLock ticket = new TicketRerntrantLock();
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                ticket.saleTcket();
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    ticket.saleTcket();
                }
            }
        }, "B").start();

    }
}


class Ticket {
    private int number = 1000;

    public synchronized void saleTcket() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + number);
            number--;
        }

    }

}

class TicketRerntrantLock {
    private int number = 1000;
    private Lock lock = new ReentrantLock();


    public void saleTcket() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + number);
                number--;
            }
        } finally {
            lock.unlock();
        }

        try {
            lock.tryLock(1000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } {

        }
    }
}