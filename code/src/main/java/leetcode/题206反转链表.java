package leetcode;

/**
 * @author yang
 * 2021年05月29日 19:14:00
 */
public class 题206反转链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

    }

    public  ListNode reverseList(ListNode head) {
        if (head == null || head.next==null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre= null;
        while(cur!= null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
