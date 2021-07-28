package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yang
 * 2021年07月20日 22:35:00
 */
public class 题179最大数 {
    public static void main(String[] args) {
        int[] num = {5,9,5,6};
        System.out.println(largestNumber(num));
    }

    public static String largestNumber(int[] nums) {
        if (nums == null) {
            return "0";
        }
        Integer[] dp = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
        }

        Arrays.sort(dp, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int n = 0;
                int nNum = o1;
                while (nNum > 0) {
                    n++;
                    nNum = nNum / 10;

                }

                int m = 0;
                int mNum = o2;
                while (mNum > 0) {
                    m++;
                    mNum = mNum / 10;
                }


                // 01前,o2后
                int r1 = o1;
                while (m > 0) {
                    r1 = r1 * 10;
                    m--;
                }
                r1 += 02;

                //o2前,01后
                int r2 = o2;
                while (n > 0) {
                    r2 = r2 * 10;
                    n--;
                }
                r2 += o1;

                return r2 - r1;
            }
        });


        if (dp[0] == 0) {
            return "0";
        }

        String s = "";

        for (int i = 0; i < dp.length; i++) {
            s += String.valueOf(dp[i]);
        }
        return s;
    }
}
