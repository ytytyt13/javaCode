package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yang
 * 2021年07月04日 17:40:00
 */
public class 题226翻转二叉树 {
    public static void main(String[] args) {

    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Deque<TreeNode> queue =  new LinkedList<>();
        queue.addLast(root);

        while(!queue.isEmpty()) {
            TreeNode treeNode = queue.pollFirst();
            TreeNode temp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = temp;
            if (treeNode.left != null) {
                queue.addLast(treeNode.left);
            }
            if (treeNode.right!= null) {
                queue.addLast(treeNode.right);
            }
        }

        return root;
    }
}
