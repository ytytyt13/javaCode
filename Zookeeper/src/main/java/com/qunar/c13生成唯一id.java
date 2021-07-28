package com.qunar;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;


/**
 * @author yang
 * 2021年02月10日 12:00:00
 */
public class c13生成唯一id implements Watcher {

    String ip = "mymv:2181";
    CountDownLatch countDownLatch =new CountDownLatch(1);
    ZooKeeper zooKeeper;

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
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public c13生成唯一id() {
        try {
            //打开连接
            zooKeeper = new ZooKeeper(ip, 5000, this);
            // 阻塞线程,等待连接的创建成功
            countDownLatch.await();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 生成id的方法
    public String getUniqueId() {
        String path = "";
        try {
            //创建临时有序节点
            path = zooKeeper.create("/uniuqeId", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return path.substring(9);
    }

    public static void main(String[] args) {
        c13生成唯一id unique = new c13生成唯一id();
        for (int i = 0; i < 10; i++) {
            System.out.println(unique.getUniqueId());
        }
    }
}
