package leetcode;

/**
 * @author yang
 * 2021年06月24日 22:40:00
 */
public class 题142环形链表II {
    public static void main(String[] args) {

    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null ) {
                return null;
            }
            fast = fast.next.next;
            slow =slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast =head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
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
