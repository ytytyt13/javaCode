package leetcode;

/**
 * @author yang
 * 2021年07月23日 20:53:00
 */
public class 题138复制带随机指针的链表 {
    public static void main(String[] args) {

        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node2.random = node1;
        node3.random = node5;
        node4.random =node3;
        node5.random = node1;

        Node node = copyRandomList(node1);
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Node cur = head;
        while(cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }

        cur = head;
        while(cur != null) {
            Node r = cur.random;
            if (r != null) {
                cur.next.random = r.next;
            }
            cur = cur.next.next;
        }

        Node newhead = new Node(-1);
        cur = newhead;
        Node p = head;
        while(p != null) {
            cur.next =p.next;
            cur = cur.next;
            p.next = cur.next;
            p = p.next;
        }

        return newhead.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
