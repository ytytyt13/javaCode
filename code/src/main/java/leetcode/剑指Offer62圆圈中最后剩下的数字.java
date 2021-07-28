package leetcode;

/**
 * @author yang
 * 2021年07月22日 20:30:00
 */
public class 剑指Offer62圆圈中最后剩下的数字 {
    public static void main(String[] args) {
        System.out.println(lastRemaining(10, 17));
    }

    public static int lastRemaining(int n, int m) {
        if (n <= 0) {
            return 0;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i < n; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        cur.next = head;

        ListNode pre = cur;
        cur = head;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m-1 ; j++) {
                pre = cur;
                cur =cur.next;
            }
            pre.next=cur.next;
            cur = cur.next;
        }

        return cur.val;
    }
}
