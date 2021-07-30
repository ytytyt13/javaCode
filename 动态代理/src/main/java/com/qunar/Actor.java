package com.qunar;

/**
 * @author yang
 * 2021年01月26日 20:56:00
 */
/**
 * 一个演员
 */
//实现了接口,就表示具有接口中的方法实现。即:符合经纪公司的要求
public class Actor implements IActor{

    public void noAct(){
        System.out.println("不想演出");
    }
    @Override
    public void basicAct(float money){
        System.out.println("拿到钱,开始基本的表演:"+money);
    }
    @Override
    public void dangerAct(float money){
        System.out.println("拿到钱,开始危险的表演:"+money);
    }
}
