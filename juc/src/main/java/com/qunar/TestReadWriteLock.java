package com.qunar;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yang
 * @Description TODO
 * @createTime 2020年11月15日 14:58:00
 */
public class TestReadWriteLock {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
            final String temp = String.valueOf(i);
            new Thread(() ->{myCache.put(temp,temp);}).start();
        }

        for (int i = 0; i < 5; i++) {
            final String temp = String.valueOf(i);
            new Thread(() ->{myCache.get(temp);}).start();
        }
    }
}


class MyCache {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    private ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private Map<String, Object> map = new HashMap<>();

    public void put(String key, Object value) {
        writeLock.lock();
        System.out.println(Thread.currentThread().getName()+"写入数据");
        map.put(key, value);
        System.out.println(Thread.currentThread().getName()+"写入完成");
        writeLock.unlock();
    }

    public void get(String key) {
        readLock.lock();
        System.out.println(Thread.currentThread().getName()+"读取数据");
        map.get(key);
        System.out.println(Thread.currentThread().getName()+"读取完成");
        readLock.unlock();
    }

}
