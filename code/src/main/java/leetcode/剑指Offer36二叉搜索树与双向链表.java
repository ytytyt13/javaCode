package leetcode;

/**
 * @author yang
 * 2021年07月17日 21:42:00
 */
public class 剑指Offer36二叉搜索树与双向链表 {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(2);
        Node node = treeToDoublyList(root);

        while(node != null) {
            System.out.println(node.val);
            node = node.right;
        }
    }

    private static Node preNode;

    public static Node treeToDoublyList(Node root) {
        if (root ==  null) {
            return root;
        }
        preNode  = new Node();
        Node head = preNode;
        MidOrder(root);
        preNode.right = head.right;
        head.right.left = preNode;
        return head.right;
    }

    public static void MidOrder(Node root) {
        if (root == null) {
            return;
        }
        MidOrder(root.left);
        preNode.right = root;
        root.left = preNode;
        preNode = preNode.right;
        MidOrder(root.right);
    }
}
