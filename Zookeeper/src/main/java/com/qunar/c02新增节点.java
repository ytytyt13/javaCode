package com.qunar;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author yang
 * 2021年02月09日 15:10:00
 */
public class c02新增节点 {
    String IP="192.168.72.128:2181";
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
    public void 创建节点1() throws KeeperException, InterruptedException {
        zooKeeper.create("/config","config".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        //zooKeeper.create("/config/url","www.baidu.com.config1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        //zooKeeper.create("/config/username","dev1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        //zooKeeper.create("/config/password","XXXXXX1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("创建节点成功");
    }

    @Test
    public void 创建节点2() throws KeeperException, InterruptedException {
        zooKeeper.create("/config2","node2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        System.out.println("创建节点成功");
    }

    @Test
    public void 创建节点3() throws KeeperException, InterruptedException {
        //world模式
        List<ACL> acls = new ArrayList<ACL>();
        Id id = new Id("world","anyone");
        acls.add(new ACL(ZooDefs.Perms.READ, id));
        acls.add(new ACL(ZooDefs.Perms.WRITE, id));
        String s = zooKeeper.create("/create/node3", "node3".getBytes(), acls, CreateMode.PERSISTENT);
        System.out.println("创建节点成功："+s);
    }

    @Test
    public void 创建节点4() throws KeeperException, InterruptedException {
        //ip授权模式
        List<ACL> acls = new ArrayList<ACL>();
        Id id = new Id("ip","100.5.81.208");
        acls.add(new ACL(ZooDefs.Perms.READ, id));
        acls.add(new ACL(ZooDefs.Perms.WRITE, id));
        String s = zooKeeper.create("/create/node4", "node4".getBytes(), acls, CreateMode.PERSISTENT);
        System.out.println("创建节点成功："+s);
    }

    @Test
    public void 创建节点5() throws KeeperException, InterruptedException {
        //digest授权模式
        zooKeeper.addAuthInfo("digest","123456".getBytes());
        String s = zooKeeper.create("/create/node5", "node5".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
        System.out.println("创建节点成功："+s);
    }

    @Test
    public void 创建节点6() throws KeeperException, InterruptedException {
        //auth授权模式
        List<ACL> acls = new ArrayList<ACL>();
        zooKeeper.addAuthInfo("digest","author:123456".getBytes());
        Id id = new Id("auth","author");
        acls.add(new ACL(ZooDefs.Perms.READ, id));
        acls.add(new ACL(ZooDefs.Perms.WRITE, id));
        String s = zooKeeper.create("/create/node666", "node666".getBytes(), acls, CreateMode.PERSISTENT);
        System.out.println("创建节点成功："+s);
    }

    @Test
    public void 创建节点7() throws KeeperException, InterruptedException {
        //digest授权模式
        List<ACL> acls = new ArrayList<ACL>();
        zooKeeper.addAuthInfo("digest","author:123456".getBytes());
        Id id = new Id("digest","author:Wktc0WylCtNWzCgu94EY5ddV18E=");
        acls.add(new ACL(ZooDefs.Perms.ALL, id));
        String s = zooKeeper.create("/create/nodeCode", "nodeCode".getBytes(), acls, CreateMode.PERSISTENT);
        System.out.println("创建节点成功："+s);
    }

    @Test
    public void 创建节点8() throws KeeperException, InterruptedException {
        //创建序列化节点
        String s = zooKeeper.create("/create/node8", "node8".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        System.out.println("创建节点成功"+s);
    }

    @Test
    public void 创建节点9() throws KeeperException, InterruptedException {
        //创建临时节点
        String s = zooKeeper.create("/create/node9", "node9".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("创建节点成功"+s);
    }

    @Test
    public void 创建节点10() throws KeeperException, InterruptedException {
        //创建节点，异步回调
        zooKeeper.create("/create/node10", "node10".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT, new AsyncCallback.StringCallback() {
            @Override
            public void processResult(int rc, String path, Object ctx, String name) {
                // 0 代表创建成功
                System.out.println(rc);
                //节点的路径
                System.out.println(path);
                //节点的路经
                System.out.println(name);
                //节点的上下文信息
                System.out.println(ctx);

            }
        },"I am Context");
        System.out.println("创建节点成功");
    }
}
