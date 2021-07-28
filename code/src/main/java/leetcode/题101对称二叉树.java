package leetcode;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yang
 * 2021年06月20日 15:40:00
 */
public class 题101对称二叉树 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(2);
        head.left.left = new TreeNode(3);
        head.left.right = new TreeNode(4);
        head.right.left = new TreeNode(4);
        head.right.right = new TreeNode(3);

        //isSymmetric(head);

        System.out.println(levelOrder(head));
    }


    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        preOrderLeft(root,arr1);
        preOrderRight(root,arr2);
        if (arr1.size() > 1 && arr1.size() == arr2.size()) {
            for (int i = 0; i < arr1.size(); i++) {
                System.out.println(arr1.get(i)+","+arr2.get(i));
                if (!arr1.get(i).equals(arr2.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void preOrderLeft(TreeNode root, List<Integer> res) {
        if (root == null) {
            res.add(-1);
            return ;
        }
        res.add(root.val);
        preOrderLeft(root.left, res);
        preOrderLeft(root.right, res);
    }

    public static void preOrderRight(TreeNode root, List<Integer> res) {
        if (root == null) {
            res.add(-1);
            return ;
        }
        res.add(root.val);
        preOrderRight(root.right, res);
        preOrderRight(root.left, res);
    }

    public static boolean levelOrder(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> temp = new LinkedList<>();
        queue.add(root);
        List<Integer> res = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                res.add(poll.val);
            }else {
                res.add(-1);
                continue;
            }
            temp.add(poll.left);
            temp.add(poll.right);
            if (queue.isEmpty()) {
                for (int i = 0; i < res.size()/2; i++) {
                   if (res.get(i).equals(res.get(res.size()-i-1))) {
                       return false;
                   }
                }
                res.clear();
                queue = temp;
            }
        }
        return true;
    }

}
