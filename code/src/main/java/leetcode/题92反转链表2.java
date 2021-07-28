package leetcode;

/**
 * @author yang
 * 2021年06月22日 22:02:00
 */
public class 题92反转链表2 {
    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ListNode listNode1 = reverseBetween(listNode, 1, 4);

        while(listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next==null) {
            return head;
        }
        int index = 1;
        ListNode begin = new ListNode();
        begin.next = head;
        ListNode newhead = begin;
        while (index <left) {
            begin = begin.next;
            index++;
        }
        begin.next = reverse(begin.next,index,right);
        return newhead.next;

    }

    public static ListNode reverse(ListNode head,int index,int right) {
        if (head == null || head.next ==null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur= pre.next;
        while (cur != null && index <= right-1) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre =cur;
            cur = temp;
            index++;
        }
        head.next = cur;
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
