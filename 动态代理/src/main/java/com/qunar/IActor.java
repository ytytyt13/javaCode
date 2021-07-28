package com.qunar;

/**
 * 一个经纪公司的要求:
 能做基本的表演和危险的表演
 *
 */
public interface IActor {
    /**
     * 基本演出
     * @param money
     */
    public void basicAct(float money);
    /**
     * 危险演出
     * @param money
     */
    public void dangerAct(float money);
}
