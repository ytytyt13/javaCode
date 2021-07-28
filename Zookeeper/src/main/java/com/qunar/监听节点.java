package com.qunar;

/**
 * @author yang
 * 2021年04月12日 11:30:00
 */

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

public class 监听节点 implements Watcher{
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static ZooKeeper zooKeeper;
    private static Stat stat = new Stat();

    public static void main(String[] args) throws Exception{
        zooKeeper = new ZooKeeper("mymv:2181", 5000, new 监听节点());
        countDownLatch.await();

        String path = "/listern1";
        //zooKeeper.create(path,"123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        System.out.println("同步读取节点内容：" + new String(zooKeeper.getData(path,true,stat)));
        System.out.println("同步读取Stat：czxid=" + stat.getCzxid()
                + ";mzxid=" + stat.getMzxid() + ";version="  + stat.getVersion());

        zooKeeper.setData(path,"123".getBytes(),-1);
        Thread.sleep(10000000);
    }

    @Override
    public void process(WatchedEvent event) {
        if (Event.KeeperState.SyncConnected == event.getState()) {
                if(Event.EventType.None == event.getType() && null == event.getPath()){ // 连接时的监听事件
                    countDownLatch.countDown();
                } else if (event.getType() == Event.EventType.NodeDataChanged){ // 子节点内容变更时的监听
                    try {
                        System.out.println("监听获得通知内容：data="
                                + new String(zooKeeper.getData(event.getPath(),true,stat)));
                        System.out.println("监听获得通知Stat：czxid=" + stat.getCzxid()
                                + ";mzxid=" + stat.getMzxid() + ";version="  + stat.getVersion());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

        }
    }
}
