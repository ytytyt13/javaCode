package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yang
 * 2021年05月27日 21:30:00
 */
public class 题103二叉树的锯齿形层序遍历 {
    public static void main(String[] args) {

        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(9);
        head.right = new TreeNode(20);
        head.right.left = new TreeNode(15);
        head.right.right = new TreeNode(7);

        List<List<Integer>> lists = zigzagLevelOrder(head);


        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j)+",");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        //声明返回结果
        List<List<Integer>> res = new ArrayList<>();
        //如果为空,直接返回
        if (root == null) {
            return res;
        }

        //通过层序遍历完成,存储层序遍历结果
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        //设置标志位
        boolean flag =true;

        while(!queue.isEmpty()) {
            //控制每一层的节点个数
            int size = queue.size();
            //基数层,数据从尾插
            //偶数层.数据从头插
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (flag) {
                    deque.addLast(poll.val);
                }else {
                    deque.addFirst(poll.val);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }

            }
            flag = !flag;
            res.add(new ArrayList<Integer>(deque));
        }
        return res;
    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
        this.right = right;
        }
    }
}
