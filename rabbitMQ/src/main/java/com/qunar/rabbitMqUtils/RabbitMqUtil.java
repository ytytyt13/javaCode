package com.qunar.rabbitMqUtils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author yang
 * 2021年02月06日 21:25:00
 */
public class RabbitMqUtil {
    private static ConnectionFactory connectionFactory;
    private RabbitMqUtil(){}

    static {
        //创建连接工厂
         connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("100.81.4.164");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/ems");
    }

    public static Connection getConnection(){
        try {
            return connectionFactory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnectAndChannel(Connection connection,Channel channel){
        try {
            if (channel != null) {
                channel.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
