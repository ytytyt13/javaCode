package 牛渴;

/**
 * @author yang
 * 2021年04月18日 18:19:00
 */
public class 题14链表中倒数第k个结点 {

    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        ListNode head1 = new ListNode(0);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(3);
        head1.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        ListNode merge = Merge(head, head1);
        System.out.println("merge");

//        Solution solution = new Solution();
//
//
//        System.out.println(solution.FindKthToTail(head, 4).getVal());
//
//        ListNode reverse = reverse(head);
//        while(reverse != null) {
//            System.out.println(reverse.getVal());
//            reverse = reverse.next;
//        }


    }

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }


    }

    public static ListNode reverse (ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = pre.next;
        ListNode temp = null;
        head.next = null;
        while(cur != null) {
            temp = cur.next;
            cur.setNext(pre);
            pre = cur;
            cur = temp;
        }

        return pre;
    }


    public static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param pHead ListNode类
         * @param k int整型
         * @return ListNode类
         */
        public ListNode FindKthToTail (ListNode pHead, int k) {
            // write code here
            ListNode first = pHead;
            ListNode last = pHead;
            int index =0;
            while(first != null  && index < k ) {
                if (first == null) {
                    return null;
                }
                first = first.next;
                index++;
            }

            while(first !=null) {
                first = first.next;
                last = last.next;

            }
            return last;
        }
    }

    public static ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode p = null;
        if (list1.val < list2.val){
            p=list1;
            list1=list1.next;
        }else {
            p=list2;
            list2=list2.next;
        }

        ListNode res= p;

        while (list1 != null && list2 != null) {
            System.out.println(p.getVal());
            if (list1.val < list2.val) {
                p.next = list1;
                list1= list1.next;
                p=p.next;
            }
            else {
                p.next = list2;
                list2= list2.next;
                p=p.next;
            }
        }

        if (list1 != null) {
            p.next = list1;
            list1= list1.next;
            p=p.next;
        }

        if (list2 != null) {
            p.next = list2;
            list2= list2.next;
            p=p.next;
        }

        return res;
    }
}
