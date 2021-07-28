package leetcode;

/**
 * @author yang
 * 2021年07月04日 16:54:00
 */
public class 题82删除排序链表中的重复元素II {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        ListNode listNode = deleteDuplicates(head);
        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode pre = new ListNode();
        ListNode cur = head;
        pre.next = head;
        head = pre;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            if (cur.val == next.val) {
                while (next != null && cur.val == next.val) {
                    cur = next;
                    next = next.next;
                }
                cur = cur.next;
                pre.next = cur;
            }else {
                cur = cur.next;
                pre =pre.next;
            }
        }



        return head.next;
    }
}
