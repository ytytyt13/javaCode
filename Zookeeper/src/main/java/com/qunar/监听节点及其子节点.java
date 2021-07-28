package com.qunar;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * @author yang
 * 2021年04月13日 10:56:00
 */
public class 监听节点及其子节点 implements Watcher{
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static ZooKeeper zooKeeper;
    private static Stat stat = new Stat();

    String path = "/listern1/test.json";
    public static void main(String[] args) throws Exception{
        zooKeeper = new ZooKeeper("mymv:2181", 5000, new 监听节点及其子节点());
        countDownLatch.await();
        System.out.println("链接完成");

        //String path = "/listern1/test.json";
        //zooKeeper.create(path,"123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        //System.out.println("同步读取节点内容：" + new String(zooKeeper.getData(path,true,stat)));
        //System.out.println("同步读取Stat：czxid=" + stat.getCzxid()
        //+ ";mzxid=" + stat.getMzxid() + ";version="  + stat.getVersion());

        //zooKeeper.setData(path,"123".getBytes(),-1);
        Thread.sleep(10000000);
    }

    @Override
    public void process(WatchedEvent event) {
        if (Event.KeeperState.SyncConnected == event.getState()) {
            if(Event.EventType.None == event.getType() && null == event.getPath()){ // 连接时的监听事件
                countDownLatch.countDown();
                try {
                    System.out.println("同步读取节点内容：" + new String(zooKeeper.getData(path,true,stat)));
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
