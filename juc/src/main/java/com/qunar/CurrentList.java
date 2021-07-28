package com.qunar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yang
 * @Description TODO
 * @createTime 2020年11月12日 20:22:00
 */
public class CurrentList {
    public static void main(String[] args) {
        new Vector();
        new ArrayList<>();
        Collections.synchronizedList(new ArrayList<>());
        CopyOnWriteArrayList<String> objects = new CopyOnWriteArrayList<>();
        objects.forEach((obj)->{
            System.out.println(obj);
        });
        for (int i = 0; i <30; i++) {
            new Thread(()->{
                objects.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(objects);
            }).start();
        }

        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString().substring(0,8));
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.of(2017, 12, 3,4,5));
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd-hh-mm-ss").format(LocalDateTime.now()));

        HashSet<String> objects1 = new HashSet<>();
        Collections.synchronizedSet(new HashSet<>());
        new CopyOnWriteArraySet();

        Collections.synchronizedMap(new HashMap<>());
        new ConcurrentHashMap<>();

        new CountDownLatch(6);
        new CyclicBarrier(6);
        new Semaphore(3);
        new ReentrantReadWriteLock();



    }
}


class Newclass extends Thread {
    @Override
    public void run() {
        System.out.println("aaa");
        new FutureTask(new Newclass1());
    }
}

class Newclass1 implements Callable<String>{
    @Override
    public String call() throws Exception {
        return null;


    }
}