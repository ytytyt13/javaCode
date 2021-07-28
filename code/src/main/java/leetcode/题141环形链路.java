package leetcode;

/**
 * @author yang
 * 2021年06月16日 21:01:00
 */
public class 题141环形链路 {
    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = null;

        System.out.println(hasCycle(p1));

    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;

        while(p1 != null && p2 != null) {
            if (p1 == p2) {
                return true;
            }
            p1 = p1.next;
            if (p2 != null)  {
                p2 = p2.next;
                if (p2 != null) {
                    p2 =p2.next;
                }
            }
        }

        return false;

    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


}
