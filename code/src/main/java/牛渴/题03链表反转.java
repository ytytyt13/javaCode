package 牛渴;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author yang
 * 2021年04月11日 18:48:00
 */
public class 题03链表反转 {

    //输入一个链表，按链表从尾到头的顺序返回一个ArrayList。

    public static void main(String[] args) {



    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (listNode == null)
            return res;
        Stack<Integer> integers = new Stack<Integer>();
        ListNode p = listNode;
        while(p != null) {
            integers.push(p.val);
            p=p.next;
        }

        while (!integers.isEmpty()) {
            res.add(integers.pop());
        }

        return res;
    }


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }
}
