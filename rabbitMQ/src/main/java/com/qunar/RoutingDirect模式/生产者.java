package com.qunar.RoutingDirect模式;

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
        connectionFactory.setHost("100.81.4.164");
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
        channel.exchangeDeclare("RoutingTest","direct");


        channel.basicPublish("RoutingTest","ERROR", MessageProperties.PERSISTENT_TEXT_PLAIN,("我是生产者:ERROR").getBytes());
        channel.basicPublish("RoutingTest","WARRING", MessageProperties.PERSISTENT_TEXT_PLAIN,("我是生产者:WARRING").getBytes());
        channel.basicPublish("RoutingTest","INFO", MessageProperties.PERSISTENT_TEXT_PLAIN,("我是生产者:INFO").getBytes());

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
