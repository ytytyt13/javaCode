package leetcode;

/**
 * @author yang
 * 2021年06月24日 23:15:00
 */
public class 题22链表中倒数第k个数 {
    public static void main(String[] args) {

    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast!= null  && k > 0) {
            fast = fast.next;
            k--;
        }
        while(fast!= null) {
            fast = fast.next;
            slow =slow.next;
        }
        return slow;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }}
}
