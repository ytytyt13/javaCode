package com.qunar;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author yang
 * 2021年02月09日 16:57:00
 */
public class c07删除节点 {
    String IP="mymv:2181";
    ZooKeeper zooKeeper;

    @Before
    public void before() {
        try {
            // 计数器对象
            CountDownLatch countDownLatch=new CountDownLatch(1);
            // arg1:服务器的ip和端口
            // arg2:客户端与服务器之间的会话超时时间以毫秒为单位的
            // arg3:监视器对象
            zooKeeper=new ZooKeeper(IP, 5000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if(event.getState()==Event.KeeperState.SyncConnected) {
                        System.out.println("连接创建成功!");
                        countDownLatch.countDown();
                    }
                }
            });
            // 主线程阻塞等待连接对象的创建成功
            countDownLatch.await();
        }catch (Exception e) {
            System.out.println("创建连接出现异常:"+e);
        }
    }

    @After
    public void after() {
        if( zooKeeper != null) {
            try {
                zooKeeper.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    @Test
    public void 删除节点1() throws KeeperException, InterruptedException {
        Stat stat1 = new Stat();
        byte[] data = zooKeeper.getData("/config", false, stat1);
        System.out.println(new String(data));
        System.out.println(stat1.getVersion());
        zooKeeper.delete("/config",stat1.getVersion());
        System.out.println("删除节点成功");
    }

    @Test
    public void 删除节点2() throws KeeperException, InterruptedException {
        //异步删除节点
        Stat stat1 = new Stat();
        byte[] data = zooKeeper.getData("/create/node2", false, stat1);
        System.out.println(new String(data));
        System.out.println(stat1.getVersion());
        zooKeeper.delete("/create/node2",stat1.getVersion(), new AsyncCallback.VoidCallback() {
            @Override
            public void processResult(int rc, String path, Object ctx) {
                System.out.println(rc);
                System.out.println(path);
                System.out.println(ctx);
            }
        },"i am context");

        System.out.println("更新节点成功");
    }
}
