package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang
 * 2021年06月13日 16:16:00
 */
public class 题54螺旋矩阵 {
    public static void main(String[] args) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList();
        if (matrix == null || matrix.length == 0){
            return res;
        }
        int up = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        while (up <= down && left <= right) {
            res.addAll(print(matrix,up++,down--,left++,right--));
        }
        return res;
    }

    public ArrayList<Integer> print(int[][] mat,int up,int down,int left ,int right){
        ArrayList<Integer> res = new ArrayList();
        //打印上边界
        for (int i = left;i<=right;i++) {
            res.add(mat[up][i]);
        }
        //打印右边界
        for (int i = up+1; i <= down ; i++) {
            res.add(mat[i][right]);
        }
        //打印下边界
        for (int i = right-1; i>=left && up < down ; i--) {
            res.add(mat[down][i]);
        }

        //打印左边界
        for (int i = down-1; i >= up+1 && left<right; i--) {
            res.add(mat[i][left]);
        }

        return res;
    }
}
