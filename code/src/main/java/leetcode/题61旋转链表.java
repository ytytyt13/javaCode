package leetcode;

/**
 * @author yang
 * 2021年07月19日 22:16:00
 */
public class 题61旋转链表 {
    public static void main(String[] args) {

        ListNode list = new ListNode(0);
        list.next = new ListNode(1);


        ListNode listNode = rotateRight(list, 2);


        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k==0) {
            return head;
        }
        int count = 0;
        ListNode root = head;
        ListNode cur = head;

        while(cur != null) {
            count++;
            cur = cur.next;
        }
        k = k%count;
        if (k== 0) {
            return head;
        }
        cur = head;
        int n = count-k;

        count = 0;

        while (cur != null && count < n -1) {
            cur = cur.next;
            count++;
        }
        ListNode newHead = cur.next;
        cur.next = null;

        cur  = newHead;
        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = root;
        return newHead;
    }
}
