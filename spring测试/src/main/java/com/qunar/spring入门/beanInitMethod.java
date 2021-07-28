package com.qunar.spring入门;

import com.qunar.spring入门.pojo.Car;
import com.qunar.spring入门.pojo.User2;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yang
 * 2021年02月19日 21:49:00
 */
public class beanInitMethod {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean的初始化回调.xml");
        User2 user = (User2)applicationContext.getBean("user2");
    }
}
