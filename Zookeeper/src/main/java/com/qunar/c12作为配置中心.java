package com.qunar;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * @author yang
 * 2021年02月10日 11:22:00
 */
public class c12作为配置中心  implements Watcher {

    String ip = "mymv:2181";
    CountDownLatch countDownLatch = new CountDownLatch(1);
    static ZooKeeper zooKeeper;

    //本地化配置信息
    private String url;
    private String username;
    private String password;

    @Override
    public void process(WatchedEvent event) {
        try {
            // 捕获事件状态
            if (event.getType() == Event.EventType.None) {
                if (event.getState() == Event.KeeperState.SyncConnected)
                {
                    System.out.println("连接成功");
                    countDownLatch.countDown();
                } else if (event.getState() == Event.KeeperState.Disconnected) {
                    System.out.println("连接断开!");
                } else if (event.getState() == Event.KeeperState.Expired)
                {
                    System.out.println("连接超时!");
                    // 超时后服务器端已经将连接释放,需要重新连接服务器端
                    zooKeeper = new ZooKeeper(ip, 6000, new c12作为配置中心());
                } else if (event.getState() ==
                        Event.KeeperState.AuthFailed) {
                    System.out.println("验证失败!");
                }
            // 当配置信息发生变化时
            } else if (event.getType() == Event.EventType.NodeDataChanged) {
                initValue();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 构造方法
    public c12作为配置中心() {
        initValue();
    }
    // 连接zookeeper服务器,读取配置信息
    public void initValue() {
        try {
            // 创建连接对象
            zooKeeper = new ZooKeeper(ip, 5000, this);
            // 阻塞线程,等待连接的创建成功
            countDownLatch.await();
            // 读取配置信息
            this.url = new String(zooKeeper.getData("/config/url", true, null));
            this.username = new String(zooKeeper.getData("/config/username", true, null));
            this.password = new String(zooKeeper.getData("/config/password", true, null));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        c12作为配置中心 configCenter = new c12作为配置中心();
        try{
            for (int i = 1; i <= 20; i++) {
                Thread.sleep(5000);
                System.out.println("url:" + configCenter.getUrl());
                System.out.println("username:" + configCenter.getUsername());
                System.out.println("password:" + configCenter.getPassword());
                System.out.println("########################################");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getUrl() {
        return url;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}
