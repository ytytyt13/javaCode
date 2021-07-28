package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author yang
 * 2021年06月20日 16:43:00
 */
public class 题23合并K个升序链表 {
    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        p1.next = new ListNode(4);
        p1.next.next = new ListNode(5);
        ListNode p2 = new ListNode(1);
        p2.next = new ListNode(3);
        p2.next.next = new ListNode(4);
        ListNode p3 = new ListNode(2);
        p3.next = new ListNode(6);

        ListNode[] lists = {p1,p2,p3};

        ListNode listNode = mergeKLists3(lists);

        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    //递归遍历
    public static ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        ListNode temp = lists[0];
        for (int i = 1; i < lists.length; i++) {
            temp = merge(temp, lists[i]);
        }
        return temp;
    }

    //二分
    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        int mid = lists.length/2;
        ListNode left = mergeKLists2(Arrays.copyOfRange(lists,0,mid));
        ListNode right = mergeKLists2(Arrays.copyOfRange(lists,mid,lists.length));
        return merge(left,right);
    }

    public static ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }

        PriorityQueue<Integer> queue =  new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            while (list != null) {
                queue.add(list.val);
                list = list.next;
            }
        }

        ListNode cur = new ListNode();
        ListNode head = cur;
        while (!queue.isEmpty()) {
            cur.next = new ListNode(queue.poll().intValue());
            cur = cur.next;
        }
        return head.next;
    }

    public static ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        ListNode head = new ListNode();
        ListNode cur = head;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                head.next = node1;
                node1= node1.next;
            }else {
                head.next = node2;
                node2= node2.next;
            }
            head = head.next;
        }

        while (node1 != null) {
            head.next = node1;
            head = head.next;
            node1 =  node1.next;
        }

        while (node2 != null) {
            head.next= node2;
            head =  head.next;
            node2 = node2.next;
        }

        return cur.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
