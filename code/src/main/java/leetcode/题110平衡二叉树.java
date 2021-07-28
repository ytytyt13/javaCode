package leetcode;

/**
 * @author yang
 * 2021年07月10日 13:16:00
 */
public class 题110平衡二叉树 {
    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root) {
        if (root== null) {
            return true;
        }
        return isBalance(root).isB;
    }

    public static Info isBalance(TreeNode root) {
        if (root == null) {
            return new Info(0,true);
        }
        Info left = isBalance(root.left);
        Info right = isBalance(root.right);
        if (!left.isB || !right.isB) {
            return new Info(0,false);
        }
        if (Math.abs(left.h - right.h) > 1) {
            return new Info(0,false);
        }
        return new Info(Math.max(left.h,right.h)+1,true);
    }

    static class Info {
        public int h;
        public boolean isB;

        Info(int h, boolean isB){
            this.h = h;
            this.isB = isB;
        }
    }
}
