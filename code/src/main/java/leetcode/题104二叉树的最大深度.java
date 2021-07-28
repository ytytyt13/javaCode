package leetcode;

/**
 * @author yang
 * 2021年07月04日 17:50:00
 */
public class 题104二叉树的最大深度 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
//        head.left = new TreeNode(9);
//        head.right = new TreeNode(20);
//        head.right.left = new TreeNode(15);
//        head.right.right = new TreeNode(7);
        System.out.println(maxDepth(head));
    }

    public static int maxDepth(TreeNode root) {
        int res= 0;
        if (root ==null) {
            return res;
        }
        return dfs(root);
    }

    public static int dfs(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = dfs(root.left);
        }
        if (root.right != null) {
            right = dfs(root.right);
        }
        return Math.max(left,right)+1;
    }
}
