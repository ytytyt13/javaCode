package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yang
 * 2021年06月13日 16:20:00
 */
public class 题102二叉树的层序遍历 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(2);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(1);
        head.right.right = new TreeNode(7);

        List<List<Integer>> lists = levelOrder(head);

        lists.forEach(n->{n.forEach(System.out::print);
            System.out.println();});


    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        getRes(nodeQueue,res);
        return res;
    }

    public static void getRes(Queue<TreeNode> nodeQueue, List<List<Integer>> resList) {
        List<Integer> res = new ArrayList<>();
        if (nodeQueue == null || nodeQueue.isEmpty()) {
            return ;
        }
        Queue<TreeNode> nodeList = new LinkedList<>();
        while(!nodeQueue.isEmpty()) {
            TreeNode root = nodeQueue.poll();
            res.add(root.val);
            if (root.left != null) {
                nodeList.add(root.left);
            }
            if (root.right != null) {
                nodeList.add(root.right);
            }
        }
        resList.add(res);
        if (nodeList != null && !nodeList.isEmpty()) {
            getRes(nodeList,resList);
        }
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
