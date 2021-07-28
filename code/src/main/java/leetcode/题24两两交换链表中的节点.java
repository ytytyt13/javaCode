package leetcode;

import com.sun.org.apache.bcel.internal.generic.LSTORE;

/**
 * @author yang
 * 2021年07月17日 22:13:00
 */
public class 题24两两交换链表中的节点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next= new ListNode(2);
        head.next.next= new ListNode(3);
        head.next.next.next= new ListNode(4);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode  pre= new ListNode();
        pre.next = head;
        swap(head,pre);
        return pre.next;
    }

    public static void swap(ListNode head, ListNode pre) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode next= head.next;
        head.next = next.next;
        next.next = head;
        pre.next = next;
        pre = next;
        swap(head.next,head);
    }
}
