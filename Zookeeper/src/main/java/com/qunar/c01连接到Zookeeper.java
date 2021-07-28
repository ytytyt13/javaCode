package com.qunar;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * @author yang
 * 2021年02月09日 15:04:00
 */
public class c01连接到Zookeeper {
    static String IP="192.168.72.128:2181";
    public static void main(String[] args) {
        ZooKeeper zooKeeper = null;
        try {
            // 计数器对象
            CountDownLatch countDownLatch = new CountDownLatch(1);
            // arg1:服务器的ip和端口
            // arg2:客户端与服务器之间的会话超时时间以毫秒为单位的
            // arg3:监视器对象
            System.out.println("开始链接");
            zooKeeper = new ZooKeeper(IP, 5000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (event.getState() == Event.KeeperState.SyncConnected) {
                        System.out.println("连接创建成功!");
                        //countDownLatch.countDown();
                    }
                }
            });
            // 主线程阻塞等待连接对象的创建成功
            //countDownLatch.await();
            // 会话编号
            System.out.println(zooKeeper.getSessionId());

        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            if (zooKeeper != null) {
                try {
                    zooKeeper.close();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
