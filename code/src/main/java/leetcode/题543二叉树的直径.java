package leetcode;

/**
 * @author yang
 * 2021年06月27日 12:15:00
 */
public class 题543二叉树的直径 {
    public static void main(String[] args) {

    }


    public static int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        dfs(root);
        return res-1;
    }
    private static int res= 0;
    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res,left+right+1);
        return Math.max(left,right)+1;
    }
}
