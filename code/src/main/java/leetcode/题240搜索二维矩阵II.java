package leetcode;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

/**
 * @author yang
 * 2021年07月04日 16:14:00
 */
public class 题240搜索二维矩阵II {
    public static void main(String[] args) {

        int[][] arr ={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix(arr, 20));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        int  i = n-1, j=0;
        while(i>=0 && j < m){
            if (matrix[i][j] == target) {
                return true;
            }else if (matrix[i][j] > target) {
                i--;
            }else {
                j++;
            }
        }

        return false;
    }
}
