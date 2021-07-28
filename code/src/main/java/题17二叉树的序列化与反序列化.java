import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author yang
 * 2021年04月24日 20:52:00
 */
public class 题17二叉树的序列化与反序列化 {
    public static void main(String[] args) {
        int[] arr = {5,3,4,-1,-1,1,-1,-1,2,-1,7,-1,-1};
        Node node = prebuildTree(arr);

        System.out.println("遍历先序");
        preOrderStack(node);
    }


    public static Node prebuildTree(int[] arr){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        Node head = bulidTree(queue);
        return head;

    }

    public static Node bulidTree(Queue<Integer> queue ){
        if (queue.isEmpty()) {
            return null;
        }
        int poll = queue.poll();
        if(poll<0){
            return null;
        }else {
            Node head = new Node(poll);
            head.left = bulidTree(queue);
            head.right = bulidTree(queue);
            return head;

        }

    }

    public static class  Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //非递归先序
    public static void preOrderStack(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack =  new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.println(head.value);
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }

    //非递归中序
    public static void inOrderStack(题15二叉树的先序遍历.TreeNode head) {
        if (head == null) {
            return ;
        }
        Stack<题15二叉树的先序遍历.TreeNode> stack =  new Stack<>();
        while(!stack.isEmpty() || head != null){
            if(head != null) {
                stack.push(head);
                head  = head.left;
            }else {
                head = stack.pop();
                System.out.println(head.value);
                head = head.right;
            }
        }

    }
}
