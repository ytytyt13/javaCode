package leetcode;

/**
 * @author yang
 * 2021年06月15日 21:12:00
 */
public class 题105从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};


    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1, inorder, 0, inorder.length-1);
    }

    public static TreeNode build(int[] preorder, int pb, int pe, int[] inorder, int ib, int ie) {
        if (pb > pe || ib > ie) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[pb]);
        int index = ib;
        while(preorder[pb] != inorder[index]) {
            index++;
        }

        treeNode.left = build(preorder,pb+1,pb+index-ib,inorder,ib,index-1);
        treeNode.right = build(preorder,pb+index-ib+1,pe,inorder,index+1,ie);

        return treeNode;


    }
}

