package com.qunar.spring入门.spring事件;

/**
 * @author yang
 * 2021年02月20日 14:44:00
 */
/**
 * 发布者
 * 可在spring的任意位置注入，用来发布事件
 * 也可以使用上下文容器ConfigurableApplicationContext来发布事件（因为它也继承了ApplicationEventPublisher）
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

public class publish1 {
    public static void main(String[] args) {
        new PublishEvent().getEvent();
    }
}



class PublishEvent {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void getEvent() {
        System.out.println("----发布1开始-------");
        MyEvent1 event = new MyEvent1(this, "新消息1");
        applicationEventPublisher.publishEvent(event);//发布者发布消息
        System.out.println("----发布1完成-------");
    }
}

