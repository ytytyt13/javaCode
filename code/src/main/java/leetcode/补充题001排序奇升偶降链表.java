package leetcode;

/**
 * @author yang
 * 2021年06月26日 16:24:00
 */
public class 补充题001排序奇升偶降链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(8);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(2);
        getOrderList(head);

    }

    public static ListNode getOrderList(ListNode head){
        if (head == null || head.next == null) {
            return null;
        }
        //链表及偶拆分
        ListNode evenHead = head;
        ListNode oddHead = head.next;
        ListNode even = head;
        ListNode odd = head.next;
        while (odd != null && odd.next != null ) {
            even.next = odd.next;
            even = even.next;
            odd.next = even.next;
            odd = odd.next;
        }
        even.next = null;

        print(evenHead);
        print(oddHead);

        //链表反转
        ListNode pre = oddHead;
        ListNode cur = pre.next;
        oddHead.next = null;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;

        }
        oddHead = pre;
        print(evenHead);
        print(oddHead);

        //链表合并
        ListNode newHead = new ListNode();
        head = newHead;
        while (evenHead != null && oddHead != null) {
            if (evenHead.val < oddHead.val) {
                head.next = evenHead;
                evenHead = evenHead.next;
                head = head.next;
            }else {
                head.next = oddHead;
                oddHead = oddHead.next;
                head = head.next;
            }
        }

        if (evenHead != null) {
            head.next =evenHead;
        }

        if (oddHead != null) {
            head.next = oddHead;
        }
        print(newHead.next);
        return newHead.next;

    }



    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void print(ListNode head) {
        while(head != null) {
            System.out.print(head.val+",");
            head = head.next;
        }
        System.out.println();
    }

}
