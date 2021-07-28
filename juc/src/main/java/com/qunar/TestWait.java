package com.qunar;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yang
 * 2021年01月13日 20:07:00
 */
public class TestWait {
    public static void main(String[] args) {
        try {
            new TestWait().wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
