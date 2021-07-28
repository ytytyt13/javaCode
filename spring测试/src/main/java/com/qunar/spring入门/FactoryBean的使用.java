package com.qunar.spring入门;

import com.qunar.spring入门.pojo.Car;
import com.qunar.spring入门.pojo.User1;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yang
 * 2021年02月19日 21:49:00
 */
public class FactoryBean的使用 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("FactoryBean的使用.xml");
        Car car1 = (Car) applicationContext.getBean("car");
        car1.getTaxi().say();
    }
}
