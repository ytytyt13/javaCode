package leetcode;

/**
 * @author yang
 * 2021年06月26日 22:00:00
 */
public class 题19删除链表的倒数第N个结点 {
    public static void main(String[] args) {

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode cur = head;
        ListNode pre = new ListNode();
        pre.next = head;
        head =pre;

        while(n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }

        while(fast != null) {
            fast = fast.next;
            cur =cur.next;
            pre = pre.next;
        }

        if (cur != null) {
            pre.next = cur.next;
        }


        return head.next;


    }

}
