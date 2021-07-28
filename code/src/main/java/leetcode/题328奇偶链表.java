package leetcode;

/**
 * @author yang
 * 2021年07月25日 14:27:00
 */
public class 题328奇偶链表 {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        oddEvenList(head);

    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null){
            return head;
        }
        ListNode head1 = head;
        ListNode head2 = head.next;
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        ListNode cur = head.next.next;
        boolean flag = true;
        while(cur != null) {
            if (flag) {
                cur1.next = cur;
                cur1 = cur1.next;
            }else {
                cur2.next = cur;
                cur2 = cur2.next;
            }
            cur = cur.next;
            flag = !flag;
        }

        cur1.next = head2;
        cur2.next = null;
        return head;
    }
}
