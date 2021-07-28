package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yang
 * 2021年06月26日 17:56:00
 */
public class 题958二叉树的完全性检验 {
    public static void main(String[] args) {

    }

    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue  =  new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (flag && node != null) {
                return false;
            }
            if (node ==null) {
                flag =true;
                continue;
            }
            queue.offer(node.left);
            queue.offer(node.right);
        }

        return true;
    }


}
