package com.qunar;

import java.util.concurrent.TimeUnit;

/**
 * @author yang
 * 2021年01月14日 11:00:00
 */
public class Synchronized的使用 {
    public static void main(String[] args) {
        UseResourses useResourses = new UseResourses();

        new Thread(()->{useResourses.increase3();}).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{useResourses.increase2();}).start();
        Thread thread = new Thread(() -> {
            useResourses.increase5();
        });
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}


class UseResourses {
    Integer i=0;
    String b = "b";
    String c = "c";
    public synchronized void increase1() {
        System.out.println("inceease1:"+i);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i++;
    }

    public synchronized void increase2() {
        System.out.println("inceease2:"+i);
        i++;
    }

    public void increase3() {
        synchronized (b) {
            try {
                TimeUnit.SECONDS.sleep(33);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("inceease3:"+i);
            i++;
        }
    }

    public void increase4() {
        synchronized (c) {
            System.out.println("inceease4:"+i);
            i++;
        }
    }
    public void increase5() {
      synchronized (this) {
          for (int j = 0; ; j++) {
              System.out.println(j);
          }
      }
    }




}
