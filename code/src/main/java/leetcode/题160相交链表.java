package leetcode;

import java.util.HashSet;

/**
 * @author yang
 * 2021年06月09日 23:02:00
 */
public class 题160相交链表 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode node = new ListNode(4);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = node;
        headA.next.next.next.next = new ListNode(5);


        ListNode headB = new ListNode(1);
        headB.next = new ListNode(2);
        headB.next.next = new ListNode(3);
        headB.next.next.next = node;
        headB.next.next.next.next = new ListNode(5);

        ListNode intersectionNode = getIntersectionNode(headA, headB);
        System.out.println(intersectionNode.val);

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pre = headA;
        HashSet<ListNode> listNodes = new HashSet<>();
        while (pre != null) {
            listNodes.add(pre);
            pre = pre.next;
        }

        pre = headB;
        while (pre != null) {
            if (listNodes.contains(pre)) {
                return pre;
            }
            pre = pre.next;
        }

        return null;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
