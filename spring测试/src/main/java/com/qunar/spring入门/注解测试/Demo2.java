package com.qunar.spring入门.注解测试;

/**
 * @author yang
 * 2021年07月22日 11:38:00
 */
public class Demo2 implements DemoInterface {
    @Override
    public void say() {
        System.out.println("demo2");
    }
}
