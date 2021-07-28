import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yang
 * 2021年04月25日 23:56:00
 */
public class 题19判断一棵树是否为搜索二叉树 {
    public static void main(String[] args) {
        int[] arr = {5,3,4,-1,-1,1,-1,-1,2,-1,7,-1,-1};
        Node node = prebuildTree(arr);

        System.out.println(isSelectTree(node));



    }

    public static boolean isSelectTree(Node head){
        if (head == null) {
            return true;
        }

        if (!isSelectTree(head.left) ||
                ! isSelectTree(head.right)) {
            return false;
        }

        if (head.left != null && head.value <head.left.value) {
            return false;
        }

        if (head.right != null && head.value > head.right.value) {
            return false;
        }
        return true;

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
