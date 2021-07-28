import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author yang
 * 2021年04月24日 19:20:00
 */
public class 题15二叉树的先序遍历 {
    public static void main(String[] args) {
        int[] var = {5,3,4,1,2,7};
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(2);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(1);
        head.right.right = new TreeNode(7);

        System.out.println("遍历先序");
        preOrder(head);
        System.out.println("非递归先序");
        preOrderStack(head);
        System.out.println("中序");
        inOrder(head);
        System.out.println("非递归中序");
        inOrderStack(head);
        System.out.println("后序");
        postOrder(head);
        System.out.println("非递归后续");
        postOrderStack(head);
        System.out.println("层序遍历");
        cengxuOrder(head);



    }

    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }


    //遍历先序
    public static void preOrder(TreeNode head){
        if (head == null) {
            return ;
        }
        System.out.println(head.value);
        preOrder(head.left);
        preOrder(head.right);
    }
    //遍历中序

    public static void inOrder(TreeNode head) {
        if (head ==null) {
            return ;
        }
        inOrder(head.left);
        System.out.println(head.value);
        inOrder(head.right);
    }

    //遍历后续
    public static void postOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        postOrder(head.left);
        postOrder(head.right);
        System.out.println(head.value);
    }

    //非递归先序
    public static void preOrderStack(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack =  new Stack<>();
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
    public static void inOrderStack(TreeNode head) {
        if (head == null) {
            return ;
        }
        Stack<TreeNode> stack =  new Stack<>();
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

    //非递归后续便利
    public static void postOrderStack(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> help = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()) {
            head = stack.pop();
            help.push(head.value);
            if (head.left != null) {
                stack.push(head.left);
            }
            if(head.right != null) {
                stack.push(head.right);
            }
        }

        while(!help.isEmpty()) {
            System.out.println(help.pop());
        }

    }

    //层序遍历
    public static void cengxuOrder(TreeNode head){
        if(head == null) {
            return;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(head);
        while(!nodeQueue.isEmpty()) {
            head = nodeQueue.poll();
            System.out.println(head.value);
            if (head.left != null) {
                nodeQueue.add(head.left);
            }
            if (head.right != null) {
                nodeQueue.add(head.right);
            }
        }
    }
}
