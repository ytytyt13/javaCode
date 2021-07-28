package leetcode;

/**
 * @author yang
 * 2021年07月14日 22:51:00
 */
public class 题114二叉树展开为链表 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(5);
        head.left.left = new TreeNode(3);

        flatten(head);

        while(head!= null) {
            System.out.println(head.val);
            head = head.right;
        }

    }

    public static void flatten(TreeNode root) {
        if (root ==  null) {
            return ;
        }
        if (root.left != null) {
            TreeNode help = root.left;
            while(help != null && help.right != null) {
                help = help.right;
            }
            help.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        flatten(root.right);
    }
}
