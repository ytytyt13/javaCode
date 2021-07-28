package leetcode;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yang
 * 2021年06月20日 18:38:00
 */
public class 题113路径总和II {


    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        List<List<Integer>> lists = pathSum(treeNode, 5);
        lists.forEach(o->o.forEach(System.out::print));


    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        hasPathSum(root, targetSum, res, queue);
        return res;
    }

    public static void hasPathSum(TreeNode root, int targetSum, List<List<Integer>> res, Deque<Integer> queue) {
        if (root == null) {
            return ;
        }
        queue.offerLast(root.val);
        if (root.left == null && root.right == null &&root.val == targetSum){
            res.add(new ArrayList<>(queue));
            queue.pollLast();
            return;
        }
        hasPathSum(root.left, targetSum - root.val, res, queue);
        hasPathSum(root.right, targetSum - root.val,res,queue);
        queue.pollLast();
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
