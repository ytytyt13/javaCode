import java.awt.print.PrinterGraphics;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yang
 * 2021年04月27日 22:15:00
 */
public class 题21判断一颗完全二叉树的节点个数 {
    public static void main(String[] args) {
        int[] arr = {7,4,5,9,-1,-1,10,-1,-1,6,11,-1,-1,-1,3,7,-1,-1,8,-1,-1};
        Node node = prebuildTree(arr);

        preOrder(node);

        System.out.println(nodeNum(node));
    }

    public static int nodeNum(Node node) {
        if (node == null) {
            return 0;
        }
        return bs(node,1,mostLeftLevel(node,1));
    }

    public static int bs(Node node,int level,int h) {
        if (level == h) {
            return 1;
        }
        if (mostLeftLevel(node.right,level+1) ==h) {
            return (1<<(h-level)) + bs(node.right,level+1,h);
        }else {
            return (1<<(h-level-1)) + bs(node.left,level+1,h);
        }
    }



    public static int mostLeftLevel(Node node,int high) {
        while(node != null) {
            high++;
            node = node.left;
        }
        return high - 1;
    }

    //遍历先序
    public static void preOrder(Node head){
        if (head == null) {
            return ;
        }
        System.out.println(head.value);
        preOrder(head.left);
        preOrder(head.right);
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
}
