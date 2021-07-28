package leetcode;

/**
 * @author yang
 * 2021年07月11日 21:52:00
 */
public class 题148排序链表 {
    public static void main(String[] args) {

    }

    public static ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    public static ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode next = slow.next;
        slow.next = null;
        slow = mergeSort(head);
        fast = mergeSort(next);

        return merge(slow, fast);
    }

    public static ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        while(h1 != null && h2 != null) {
            if(h1.val <= h2.val) {
                pre.next = h1;
                pre = pre.next;
                h1 = h1.next;
            } else {
                pre.next = h2;
                pre = pre.next;
                h2 = h2.next;
            }
        }
        if(h1 != null) pre.next = h1;
        if(h2 != null) pre.next = h2;

        return dummy.next;
    }
}