package com.qunar;

/**
 * @author yang
 * 2021年01月26日 21:09:00
 */

/**
 * 一个演员,还是那个演员的例子,只不过不让他实现接口。
 */
public class Actor2 {//没有继承任何接口

    public void noAct(){
        System.out.println("不想演出");
    }

    public void basicAct(float money) {
        System.out.println("拿到钱,开始基本的表演:" + money);
    }

    public void dangerAct(float money) {
        System.out.println("拿到钱,开始危险的表演:" + money);
    }
}