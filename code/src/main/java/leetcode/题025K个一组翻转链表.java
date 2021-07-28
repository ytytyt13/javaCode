package leetcode;

import 牛渴.题14链表中倒数第k个结点;

/**
 * @author yang
 * 2021年05月29日 17:31:00
 */
public class 题025K个一组翻转链表 {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);



        ListNode preHead = new ListNode();
        preHead.next= head;

        NodeRevsrseInLength(preHead,3);

        ListNode listNode = preHead.next;
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }

    public static ListNode NodeRevsrse(ListNode head) {
        ListNode cur ;
        if (head == null || (cur = head.next) == null ) {
            return head;
        }
        ListNode pre =head;
        //头节点一定要置空
        head.next = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre =cur;
            cur = temp;

        }
        return pre;
    }

    public static void NodeRevsrseInLength(ListNode prehead, int k) {

        //保留头节点,作为下一阶段的prehead
        ListNode head = prehead.next;
        ListNode cur;
        if (head == null || (cur = head.next) == null || k==1) {
            return ;
        }
        //检查足后部分是否长度大于k
        ListNode node = head;
        int index = 0;
        while(node != null) {
            node=node.next;
            index ++;
        }
        if (index < k ) {
            return ;
        }


        ListNode pre =head;
        pre.next = null;
        int i =1;
        while (cur != null && i < k ) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre =cur;
            cur = temp;
            i++;

        }
        //将头节点返回
        prehead.next = pre;

        //原来的头节点指向下一个分段
        head.next = cur;

        //递归进入下一层,pre作为作为prehead
        NodeRevsrseInLength(head,k);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}


