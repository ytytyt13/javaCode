package com.qunar.spring入门;

import com.qunar.spring入门.pojo.User2;
import com.qunar.spring入门.pojo.User3;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yang
 * 2021年02月20日 12:18:00
 */
public class postProcessor的使用 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("postProcessor.xml");
        User3 user = (User3)applicationContext.getBean("user3");
        System.out.println(user);
    }
}
