package com.qunar;

import java.util.concurrent.TimeUnit;

/**
 * @author yang
 * 2021年05月18日 17:46:00
 */
public class volatitle关键字的使用 {

    public static void main(String[] args) {
        // 资源类
        MyData myData = new MyData();

        // 线程A

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");



            synchronized (myData) {
                myData.setNumber60();


                System.out.println(Thread.currentThread().getName() + "\t updated number value " + myData.number);

                // 模拟操作时间 3S
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        // 线程B
        new Thread(() -> {
            while (true){
                System.out.println(myData.number);
            }
        }, "B").start();
    }

}


class MyData {
    int number;
    public void setNumber60() {
        number++;
    }
}
