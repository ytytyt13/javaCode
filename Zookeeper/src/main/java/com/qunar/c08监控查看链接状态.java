package com.qunar;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author yang
 * 2021年02月09日 18:17:00
 */
public class c08监控查看链接状态 implements Watcher{

    static String ip = "mymv:2181";
    // 计数器对象
    static CountDownLatch countDownLatch = new CountDownLatch(1);
    // 连接对象
    static ZooKeeper zooKeeper;

    @Override
    public void process(WatchedEvent event) {

        //得到通知类型，当链接状态变化时，事件类型为none
        if (event.getType() == Event.EventType.None) {
            if (event.getState() == Event.KeeperState.SyncConnected) {
                System.out.println("链接创建成功");
                countDownLatch.countDown();
            }else if (event.getState() == Event.KeeperState.Disconnected) {
                System.out.println("断开链接");
            }else if (event.getState() == Event.KeeperState.Expired) {
                System.out.println("会话超时");
                try {
                    zooKeeper = new ZooKeeper(ip, 5000, new c08监控查看链接状态());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if (event.getState() == Event.KeeperState.AuthFailed) {
                System.out.println("认证失败");
            }
        }
    }

    public static void main(String[] args) {
        try {
            zooKeeper = new ZooKeeper(ip, 5000, new c08监控查看链接状态());
            // 阻塞线程等待连接的创建
            countDownLatch.await();
            // 会话id
            System.out.println(zooKeeper.getSessionId());
            // 添加授权用户
            zooKeeper.addAuthInfo("digest","author:123456".getBytes());
            byte [] bs=zooKeeper.getData("/create/nodeCode",false,null);
            System.out.println(new String(bs));
            Thread.sleep(50000);
            zooKeeper.close();
            System.out.println("结束");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

