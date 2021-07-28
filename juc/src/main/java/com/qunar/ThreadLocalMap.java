package com.qunar;

/**
 * @author yang
 * 2021年07月14日 16:46:00
 */
public class ThreadLocalMap {

    public static ThreadLocal<Integer> ti = new ThreadLocal<Integer>();
    public static void main(String[] args) {
        ti.set(1);
        ti.get();
        ti.remove();
    }
}
