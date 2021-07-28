package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yang
 * 2021年07月25日 12:42:00
 */
public class 题145二叉树的后序遍历 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(2);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(1);
        head.right.right = new TreeNode(7);

        List<Integer> integers = postorderTraversal(head);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return  new ArrayList<>();
        }

        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> res = new Stack<>();

        st.push(root) ;
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            res.push(node.val);
            if (node.left != null) {
                st.push(node.left);
            }
            if (node.right != null) {
                st.push(node.right);
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!res.isEmpty()) {
            result.add(res.pop());
        }
        return result;
    }
}
