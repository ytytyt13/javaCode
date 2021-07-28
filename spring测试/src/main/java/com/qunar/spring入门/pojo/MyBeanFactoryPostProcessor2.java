package com.qunar.spring入门.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.annotation.Order;

import java.lang.annotation.Annotation;

/**
 * @author yang
 * 2021年04月07日 20:47:00
 */
public class MyBeanFactoryPostProcessor2 implements BeanFactoryPostProcessor, Order {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("执行postProcessBeanFactory2方法");
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            if("springbean".equals(beanDefinitionName)) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
                MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
                if(propertyValues.contains("name")) {
                    propertyValues.addPropertyValue("name","第三个名字");
                    System.out.println("又修改了属性值");
                }
            }
        }
    }

    @Override
    public int value() {
        return 1;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
