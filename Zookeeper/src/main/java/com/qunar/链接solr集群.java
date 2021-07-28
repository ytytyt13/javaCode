package com.qunar;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * @author yang
 * 2021年04月09日 15:37:00
 */
public class 链接solr集群 {
    public static void main(String[] args) {
        ZooKeeper zooKeeper = null;
        try {
            // 计数器对象
            CountDownLatch countDownLatch = new CountDownLatch(1);
            // arg1:服务器的ip和端口
            // arg2:客户端与服务器之间的会话超时时间以毫秒为单位的
            // arg3:监视器对象
            System.out.println("开始链接");
            //zooKeeper = new ZooKeeper("l-zk1.vc.cn6.qunar.com:2181,l-zk2.vc.cn6.qunar.com:2181,l-zk3.vc.cn6.qunar.com:2181,l-zk4.vc.cn2.qunar.com:2181,l-zk5.vc.cn2.qunar.com:2181,l-zk6.vc.cn5.qunar.com:2181", 5000, new Watcher() {
            zooKeeper = new ZooKeeper("l-search2.s.cn6.qunar.com:2181/qsearch-beta1", 5000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (event.getState() == Event.KeeperState.SyncConnected) {
                        System.out.println("连接创建成功!");
                        countDownLatch.countDown();
                    }
                }
            });
            // 主线程阻塞等待连接对象的创建成功
            countDownLatch.await();
            // 会话编号
            System.out.println(zooKeeper.getSessionId());


            //查看节点
            Stat stat1 = new Stat();
            byte[] data = zooKeeper.getData("/clusterstate.json", false, stat1);
            System.out.println(new String(data));
            System.out.println(stat1.getVersion());
            System.out.println("查看节点成功");

            ObjectMapper mapper = new ObjectMapper();
            JsonNode vac_engines =  mapper.readTree(new String(data))
                    .findValue("vac_engine")
                    .findValue("shards")
                    .findValue("replicas");

            for (JsonNode vac_engine : vac_engines) {
                String varState = vac_engine.get("base_url").asText();
                String state = vac_engine.get("state").asText();
                if ("active".equals(state)){
                    System.out.println(varState);
                    System.out.println(vac_engine.get("base_url"));
                }
            }

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
