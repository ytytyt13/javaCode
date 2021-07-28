package com.qunar.spring入门.spring事件;

/**
 * @author yang
 * 2021年02月20日 14:45:00
 */

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 监听者
 * 实现ApplicationListener接口
 *
 */
@Component
public class Listener1 implements ApplicationListener<MyEvent1> {

    @Override
    public void onApplicationEvent(MyEvent1 event) {
        System.out.println("Listener1 收到事件通知：" + event.getMessage());
        //do something
    }
}
