package com.qunar;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yang
 * @Description TODO
 * @createTime 2020年11月11日 22:36:00
 */
public class 先线程循序唤醒 {
    public static void main(String[] args) {
        WriteChart writeChart = new WriteChart();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                writeChart.write();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                writeChart.write();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                writeChart.write();
            }
        },"C").start();
    }
}

class WriteChart{
    private int num=0;
    private Lock lock=new ReentrantLock();
    private Condition condition1=lock.newCondition();
    private Condition condition2=lock.newCondition();
    private Condition condition3=lock.newCondition();

    public void write(){
        lock.lock();
        String name = Thread.currentThread().getName();
        try{
            if("A".equals(name)){
                while(num!=0){
                    try {
                        condition1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num=1;
                System.out.print("AAAAA");
                condition2.signalAll();
            }else if("B".equals(name)){
                while(num!=1){
                    try {
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num=2;
                System.out.print("BBBBBBBBBB");
                condition3.signalAll();
            }else if("C".equals(name)){
                while(num!=2){
                    try {
                        condition3.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num=0;
                System.out.println("CCCCCCCCCCCCCCCCC");
                condition1.signalAll();
            }
        }finally {
            lock.unlock();
        }
    }

    public void writeA(){
        lock.lock();
        try{
            while(num!=0){
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num = 1;
            System.out.print("AAAAA");
            condition2.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void writeB(){
        lock.lock();
        try{
            while(num!=1){
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num=2;
            System.out.print("BBBBBBBBBBB");
            condition3.signalAll();
        }finally {
            lock.unlock();
        }
    }


    public void writeC(){
        lock.lock();
        try{
            while(num!=2){
                try {
                    condition3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num=0;
            System.out.println("CCCCCCCCCCCCCCC");
            condition1.signalAll();
        }finally {
            lock.unlock();
        }

    }



}
