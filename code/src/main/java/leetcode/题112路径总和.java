package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yang
 * 2021年06月16日 21:17:00
 */
public class 题112路径总和 {
    public static void main(String[] args) {

    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);

    }

    public static boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Deque<TreeNode> rootDeque = new LinkedList<>();
        Deque<Integer> sumDeque = new LinkedList<>();

        rootDeque.addLast(root);
        sumDeque.addLast(targetSum);


        while (!rootDeque.isEmpty()) {
            TreeNode pre  =  rootDeque.pollFirst();
            Integer sum = sumDeque.pollFirst();
            if (pre.left == null && pre.right == null && pre.val == sum) {
                return true;
            }
            if (pre.left != null) {
                rootDeque.addLast(pre.left);
                sumDeque.addLast(sum -pre.val);
            }
            if (pre.right != null) {
                rootDeque.addLast(pre.right);
                sumDeque.addLast(sum -pre.val);
            }
        }

        return false;


    }



}
