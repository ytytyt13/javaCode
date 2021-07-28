package com.qunar.spring入门;


import com.qunar.spring入门.pojo.User1;
import com.qunar.spring入门.pojo.测试spring的生命周期对象;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yang
 * 2021年02月19日 20:00:00
 */
public class 测试spring的生命周期 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring的生命周期.xml");
        测试spring的生命周期对象 b= (测试spring的生命周期对象)applicationContext.getBean("springbean");
        System.out.println(b.getName());
        applicationContext.close();
    }
}
