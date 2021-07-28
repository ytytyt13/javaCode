
package com.qunar;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * @author yang
 * 2021年01月14日 15:50:00
 */
public class TestThreadLocal {
    public static void main(String[] args) {

        MyThreadLocal myThreadLocal = new MyThreadLocal();
        new Thread(()->{myThreadLocal.addThreadLocalNum();},"a").start();
        new Thread(()->{myThreadLocal.addThreadLocalNum();},"b").start();
        new Thread(()->{myThreadLocal.addThreadLocalNum();},"c").start();

    }
}

class MyThreadLocal {
    //private static ThreadLocal<Integer> THREAD_LOCAL_NUM = ThreadLocal.withInitial(() -> 0);
    private  ThreadLocal<Integer> THREAD_LOCAL_NUM = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public void addThreadLocalNum() {
        try{
            for (int i = 0; i < 5; i++) {
                int n= THREAD_LOCAL_NUM.get();
                n++;
                THREAD_LOCAL_NUM.set(n);
                System.out.println("线程名："+Thread.currentThread().getName()+"   num:"+n);
            }
        }finally {
            THREAD_LOCAL_NUM.remove();
        }

    }
}

