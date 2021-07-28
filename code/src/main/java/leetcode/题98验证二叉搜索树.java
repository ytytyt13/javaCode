package leetcode;

/**
 * @author yang
 * 2021年06月26日 18:37:00
 */
public class 题98验证二叉搜索树 {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        TreeNode head = new TreeNode(2);
        head.left = new TreeNode(2);
        head.right = new TreeNode(2);
        System.out.println(isValidBST(head));

    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

       return getSearchTree(root).isS;
    }

    private static int pre = Integer.MIN_VALUE;

    public static boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!dfs(root.left)) {
            return false;
        }
        if (root.val < pre) {
            return false;
        }
        pre = root.val;
        return dfs(root.right);
    }


    public static ReturnData getSearchTree(TreeNode root) {
        if (root == null ) {
            return new ReturnData(true);
        }
        ReturnData left = getSearchTree(root.left);
        ReturnData right = getSearchTree(root.right);
        if (!left.isS || !right.isS) {
            return new ReturnData(false);
        }
        if (left.max != null && left.max > root.val) {
            return new ReturnData(false);
        }
        if (right.max != null && right.max < root.val) {
            return new ReturnData(false);
        }
        return new ReturnData(true,right.max);
    }

    public static class ReturnData {
        boolean isS;
        Integer max;

        ReturnData(){

        }

        public ReturnData(boolean isS) {
            this.isS = isS;
        }

        public ReturnData(Integer max) {
            this.max = max;
        }

        public ReturnData(boolean isS, Integer max) {
            this.isS = isS;
            this.max = max;
        }
    }
}
