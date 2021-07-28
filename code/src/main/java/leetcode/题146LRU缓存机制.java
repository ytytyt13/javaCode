package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yang
 * 2021年05月30日 20:41:00
 */
public class 题146LRU缓存机制 {
    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,0);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        //System.out.println(lruCache.get(3));
        //System.out.println(lruCache.get(4));

        System.out.println("-------------");
        CacheNode node = lruCache.head;
        while(node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }




}

class CacheNode {
    public int key;
    public int val;
    public CacheNode pre;
    public CacheNode next;

    CacheNode(int key,int val) {
        this.key = key;
        this.val = val;
    }

    CacheNode(){
    }
}


class LRUCache {
    public int size;
    public int capacity;
    private Map<Integer, CacheNode> map;
    public CacheNode head;
    public CacheNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<>();
        head = new CacheNode();
        tail = new CacheNode();
        head.next = tail;
        tail .pre =head;
    }

    public int get(int key) {
        CacheNode cacheNode = map.get(key);
        //如果没有返回-1
        if (cacheNode == null) {
            return -1;
        }
        //如果有.拿到值,则将节点移到表头
        int res = cacheNode.val;
        moveToHead(cacheNode);
        return res;
    }

    public void put(int key, int value) {
        CacheNode cacheNode = map.get(key);
        //之前就有数据
        if (cacheNode != null) {
            cacheNode.val = value;
            //移动数据到表头
            moveToHead(cacheNode);
        }else {
            //如果没有数据,则产生新的节点,加入到map,和链表
            cacheNode = new CacheNode(key,value);
            map.put(key,cacheNode);
            cacheNode.pre = head;
            cacheNode.next = head.next;
            head.next.pre = cacheNode;
            head.next = cacheNode;
            size ++;
            if (size > capacity) {
                remove(tail.pre);
                size--;
            }
        }


    }

    public void remove(CacheNode node) {
        if (node == null) {
            return ;
        }
        //移出map
        map.remove(node.key);
        //移出链表
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
    }

    public void moveToHead(CacheNode node) {
        if (node == null) {
            return ;
        }
        //移出
        node.pre.next = node.next;
        node.next.pre = node.pre;

        //加入表头
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }
}
