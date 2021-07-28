package leetcode;

/**
 * @author yang
 * 2021年07月24日 17:05:00
 */
public class 题297二叉树的序列化与反序列化 {
    public static void main(String[] args) {
        String s = "#,2,#,1,4,#,#,3,5,#,#";
        TreeNode deserialize = deserialize(s);

        System.out.println(serialize(deserialize));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val+","+left+","+right;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] split = data.split(",");
        TreeNode root = new TreeNode();
        TreeNode serial = preorder(root, split);
        return serial;
    }
    public static int index = 0;
    public static TreeNode preorder(TreeNode root,String[] data) {
        if (index >= data.length || data[index].equals("#")) {
            index++;
            return null;
        }
        root = new TreeNode(Integer.valueOf(data[index]));
        index++;
        root.right= preorder(root.right,data);
        return root;
    }


}
