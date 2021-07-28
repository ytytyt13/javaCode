package leetcode;

/**
 * @author yang
 * 2021年07月03日 17:38:00
 */
public class 题718最长重复子数组 {
    public static void main(String[] args) {

        int[] a = {0,0,0,0,0};
        int[] b = {0,0,0,0,0};

        System.out.println(findLength(a, b));

        System.out.println(maxLen(a, 0, b, 0, 5));
    }

    public static int findLength(int[] nums1, int[] nums2) {
        return nums1.length < nums2.length ? findMax(nums1,nums2):findMax(nums2,nums1);
    }

    public static int findMax(int[] A, int[] B) {
        int res = 0;
        int an = A.length;
        int bn = B.length;

        //第一阶段
        for (int i = 1; i <= an; i++) {
            res = Math.max(res, maxLen(A,0,B,bn-i,i));
        }

        //第二阶段
        for (int i = 0; i < bn - an; i++) {
            res = Math.max(res,maxLen(A,0,B,bn-i-an,an));
        }

        //第三阶段
        for (int i = 1; i < an; i++) {
            res = Math.max(res, maxLen(A,i,B,0,an-i));
        }

        return res;



    }

    public static int maxLen(int[] A,int i, int[] B, int j, int len) {
        int count =0;
        int max = 0;
        for (int k = 0; k < len; k++) {
            if (A[i+k] == B[j+k]) {
                count ++;
            }else {
                max = Math.max(max,count);
                count = 0;
            }
        }

        return count>0?Math.max(max,count):max;
    }
}
