package leetcode;

/**
 * @author yang
 * 2021年06月26日 18:11:00
 */
public class 题2两数相加 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 ==null) {
            return l1;
        }
        ListNode head = new ListNode();
        ListNode temp = head;
        int add = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val +l2.val+add;
            add = sum / 10;
            sum = sum % 10;
            head.next = new ListNode(sum);
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            if (add == 0) {
                head.next = l1;
                break;
            }
            int sum = l1.val+add;
            add = sum / 10;
            sum = sum % 10;
            head.next = new ListNode(sum);
            head = head.next;
            l1 = l1.next;

        }

        while (l2 != null) {
            if (add == 0) {
                head.next = l2;
                break;
            }
            int sum = l2.val+add;
            add = sum / 10;
            sum = sum % 10;
            head.next = new ListNode(sum);
            head = head.next;
            l2 = l2.next;

        }
        if (add != 0) {
            head.next = new ListNode(add);
        }
        return temp.next;
    }


}
