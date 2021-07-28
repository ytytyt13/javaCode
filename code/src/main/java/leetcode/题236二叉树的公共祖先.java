package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author yang
 * 2021年06月10日 21:53:00
 */
public class 题236二叉树的公共祖先 {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p ==null || q==null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        }

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        return root;

    }

    private Map<TreeNode, TreeNode> parent = new HashMap<>();
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p ==null || q==null) {
            return null;
        }
        dfs(root);
        HashSet<TreeNode> treeRoute =  new HashSet<>();
        while(p != null) {
            treeRoute.add(p);
            p = parent.get(p);
        }

        while(q != null) {
            if (treeRoute.contains(q)) {
                return q;
            }
            q=parent.get(q);
        }

        return null;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return ;
        }
        if (root.left != null) {
            parent.put(root.left,root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right,root);
            dfs(root.right);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
