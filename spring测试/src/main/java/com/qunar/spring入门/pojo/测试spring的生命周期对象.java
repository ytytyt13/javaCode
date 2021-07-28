package com.qunar.spring入门.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.beans.PropertyDescriptor;

/**
 * @author yang
 * 2021年04月07日 20:41:00
 */
public class 测试spring的生命周期对象 implements InitializingBean, DisposableBean , BeanNameAware {

    //自身属性值
    private int id;
    private String name;
    private String beanName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("属性注入");
        this.name = name;
    }

    public 测试spring的生命周期对象(){
        System.out.println("实例化");
    }

    @PostConstruct
    public void start1(){
        System.out.println("执行postConstruct");
    }

    public void start2() {
        System.out.println("执行init-method方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("执行destroy");
    }

    public void end2() {
        System.out.println("执行destory-method");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("执行aware方法");
        this.beanName=name;
    }

    @PreDestroy
    public void end1() {
        System.out.println("执行pre-destory()方法");
    }
}
