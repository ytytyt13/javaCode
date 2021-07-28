package com.qunar;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author yang
 * 2021年01月26日 21:04:00
 */
public class 基于子类的动态代理 {
    /**
     * 基于子类的动态代理
     要求:
     被代理对象不能是最终类
     用到的类:
     Enhancer
     用到的方法:
     create(Class, Callback)
     方法的参数:
     * Class:被代理对象的字节码
     * Callback:如何代理
     * @param args
     */
    public static void main(String[] args) {
        Actor2 actor = new Actor2();
        Actor2 cglibActor = (Actor2) Enhancer.create(actor.getClass(),
                new MethodInterceptor() {
                    /**
                     * 执行被代理对象的任何方法,都会经过该方法。在此方法内部就可以对被代理对象的任何
                     方法进行增强。
                     *
                     * 参数:
                     * 前三个和基于接口的动态代理是一样的。
                     * MethodProxy:当前执行方法的代理对象。
                     * 返回值:
                     *
                     当前执行方法的返回值
                     */
                    @Override
                    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                        String name = method.getName();
                        Float money = (Float) args[0];
                        Object rtValue = null;
                        if("basicAct".equals(name)){
                            //基本演出
                            if(money > 2000){
                                rtValue = method.invoke(actor, money/2);
                            }
                        }
                        if("dangerAct".equals(name)){
                            //危险演出
                            if(money > 5000){
                                rtValue = method.invoke(actor, money/2);
                            }
                        }
                        return rtValue;
                    }
                });
        cglibActor.basicAct(2000);
        cglibActor.dangerAct(100000);
    }
}
