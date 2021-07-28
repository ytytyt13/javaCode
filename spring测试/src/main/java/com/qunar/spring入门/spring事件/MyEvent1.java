package com.qunar.spring入门.spring事件;

import org.springframework.context.ApplicationEvent;

/**
 * @author yang
 * 2021年02月20日 14:42:00
 */
public class MyEvent1 extends ApplicationEvent {
    private String message;

    public MyEvent1(Object source,String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
