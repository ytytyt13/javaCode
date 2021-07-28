package leetcode;

/**
 * @author yang
 * 2021年07月04日 16:30:00
 */
public class 题83删除排序链表中的重复元素 {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        ListNode listNode = deleteDuplicates(head);
        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null) {
            if (pre.val != cur.val) {
                cur = cur.next;
                pre = pre.next;
            }else {
                cur = cur.next;
                pre.next = cur;
            }
        }

        return head;
    }
}
