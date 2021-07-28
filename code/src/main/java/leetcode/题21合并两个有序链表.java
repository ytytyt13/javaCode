package leetcode;

/**
 * @author yang
 * 2021年06月12日 19:49:00
 */
public class 题21合并两个有序链表 {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(l1, l2);

        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode pre = new ListNode();
        ListNode head = pre;

        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre =pre.next;
        }

        if (l1 != null) {
            pre.next = l1;

        }

        if  (l2 != null) {
            pre.next = l2;
        }

        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }}
}
