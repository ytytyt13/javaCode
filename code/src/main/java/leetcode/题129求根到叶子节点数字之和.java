package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yang
 * 2021年06月24日 22:50:00
 */
public class 题129求根到叶子节点数字之和 {
    public static void main(String[] args) {

    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<List<Integer>> temp = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        dfs(root, res, temp);
        int num = 0;
        for (int i = 0; i < temp.size(); i++) {
            int m = 0;
            for (int j = 0; j < temp.get(i).size(); j++) {
                m = m*10+temp.get(i).get(j);
            }
            num += m;
        }
        return num;
    }

    public static void dfs(TreeNode root,ArrayList<Integer> res,List<List<Integer>> temp) {
        if (root == null) {
            return ;
        }
        res.add(root.val);
        if (root.left == null && root.right == null) {
            temp.add(res);
        }
        dfs(root.left, new ArrayList<>(res),temp);
        dfs(root.right, new ArrayList<>(res),temp);
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
