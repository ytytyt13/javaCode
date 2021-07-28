package com.qunar.spring入门;

import com.qunar.spring入门.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yang
 * 2020年12月29日 14:55:00
 */
public class Demo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);
    }
}
