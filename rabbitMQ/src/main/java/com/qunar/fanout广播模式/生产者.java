package com.qunar.fanout广播模式;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author yang
 * 2021年02月06日 20:58:00
 */
public class 生产者 {
    public static void main(String[] args) {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.1.19");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/ems");
        Connection connection = null;
        Channel channel = null;
        try {
            connection = connectionFactory.newConnection();

        //创建通道
        channel = connection.createChannel();
        channel.exchangeDeclare("exchangeTest1","fanout");

        for (int i = 0; i<1000; i++) {
            channel.basicPublish("exchangeTest1","", MessageProperties.PERSISTENT_TEXT_PLAIN,("我是生产者:"+i).getBytes());
        }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }finally {
            try {
                channel.close();
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
    }
}
