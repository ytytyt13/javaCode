package 牛渴;

import java.util.Arrays;

/**
 * @author yang
 * 2021年04月11日 19:03:00
 */
public class 题04重建二叉树 {
    public static void main(String[] args) {

    }

    public static class Solution {
        public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

            if (pre.length == 0 || in.length == 0) {
                return null;
            }

            int nodeValue  = pre[0];
            TreeNode node = new TreeNode(nodeValue);
            for(int i = 0;  i< in.length;i++) {
                if (nodeValue == in[i]) {
                    if (in[i] == pre[0]) {
                        // 左子树，注意 copyOfRange 函数，左闭右开
                        node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                        // 右子树，注意 copyOfRange 函数，左闭右开
                        node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                        break;
                    }
                }
            }
            return node;
        }
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
