import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yang
 * 2021年04月25日 23:41:00
 */
public class 题18判断一棵树是否为平衡二叉树 {
    public static void main(String[] args) {
        int[] arr = {5,3,4,-1,-1,1,-1,-1,2,-1,7,-1,-1};
        Node node = prebuildTree(arr);
        ReturnData banlaceTree = isBanlaceTree(node);
        System.out.println(banlaceTree.isB);
        System.out.println(banlaceTree.h);


    }

    public static ReturnData isBanlaceTree(Node head){
        if (head == null) {
            return new ReturnData(true,0);
        }
        ReturnData lTree = isBanlaceTree(head.left);
        ReturnData rTree = isBanlaceTree(head.right);


        if (!lTree.isB || !rTree.isB || lTree.h -rTree.h>1) {
            return new ReturnData(false,0);
        }

        return new ReturnData(true, lTree.h>rTree.h?lTree.h+1:rTree.h+1);
    }

    public static class ReturnData{
        public boolean isB;
        public int h;
        public ReturnData(boolean isB, int h){
            this.isB = isB;
            this.h = h;
        }
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
