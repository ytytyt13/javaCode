package com.qunar;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author yang
 * 2021年02月10日 12:11:00
 */
public class c14分布式锁 implements Watcher {

    String ip = "mymv:2181";
    CountDownLatch countDownLatch =new CountDownLatch(1);
    ZooKeeper zooKeeper;


    private static final String LOCK_ROOT_PATH = "/Locks";
    private static final String LOCK_NODE_NAME = "Lock_";
    private String lockPath;

    @Override
    public void process(WatchedEvent event) {
        try {
            // 捕获事件状态
            if (event.getType() == Watcher.Event.EventType.None) {
                if (event.getState() == Watcher.Event.KeeperState.SyncConnected)
                {
                    System.out.println("连接成功");
                    countDownLatch.countDown();
                } else if (event.getState() == Watcher.Event.KeeperState.Disconnected) {
                    System.out.println("连接断开!");
                } else if (event.getState() == Watcher.Event.KeeperState.Expired)
                {
                    System.out.println("连接超时!");
                    // 超时后服务器端已经将连接释放,需要重新连接服务器端
                    zooKeeper = new ZooKeeper(ip, 6000, new c12作为配置中心());
                } else if (event.getState() ==
                        Watcher.Event.KeeperState.AuthFailed) {
                    System.out.println("验证失败!");
                }
            }else if (event.getType() == Event.EventType.NodeDeleted) {

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public c14分布式锁() {
        try {
            //打开连接
            zooKeeper = new ZooKeeper(ip, 500000, this);
            // 阻塞线程,等待连接的创建成功
            countDownLatch.await();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void acquireLock() throws Exception {
        //创建锁节点
        createLock();
        //尝试获取锁
        attemptLock();
    }

    //创建锁节点
    private void createLock() throws Exception {
        //判断Locks是否存在,不存在创建
        Stat stat = zooKeeper.exists(LOCK_ROOT_PATH, false);
        if (stat == null) {
            zooKeeper.create(LOCK_ROOT_PATH, new byte[0],
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        // 创建临时有序节点
        lockPath = zooKeeper.create(LOCK_ROOT_PATH + "/" + LOCK_NODE_NAME,
                new byte[0],
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("节点创建成功:" + lockPath);
    }

    //尝试获取锁
    private void attemptLock() throws Exception {
        // 获取Locks节点下的所有子节点
        List<String> list = zooKeeper.getChildren(LOCK_ROOT_PATH, false);
        // 对子节点进行排序
        Collections.sort(list);
        // /Locks/Lock_000000001
        int index = list.indexOf(lockPath.substring(LOCK_ROOT_PATH.length() + 1));
        if (index == 0) {
            System.out.println("获取锁成功!");
            return;
        } else {
            // 上一个节点的路径
            String path = list.get(index - 1);
            Stat stat = zooKeeper.exists(LOCK_ROOT_PATH + "/" + path, this);
            if (stat == null) {
                attemptLock();
            } else {
                synchronized (this) {
                    this.wait();
                }
                attemptLock();
            }
        }
    }

    //释放锁
    public void releaseLock() throws Exception {
        //删除临时有序节点
        zooKeeper.delete(this.lockPath,-1);
        zooKeeper.close();
        System.out.println("锁已经释放:"+this.lockPath);
    }

    public static void main(String[] args) {
        try {
            c14分布式锁 myLock = new c14分布式锁();
            myLock.acquireLock();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
