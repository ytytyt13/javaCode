package leetcode;

/**
 * @author yang
 * 2021年07月07日 21:43:00
 */
public class 背包问题 {
    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int maxW = 4;

        //getValue(weight,value,maxW);
        getValue2(weight,value,maxW);
    }

    public static int getValue(int[] weight, int[] value, int maxW) {
        int[][] dp = new int[value.length][maxW+1];

        for (int j = 0; j <=maxW; j++) {
            if (j >= weight[0]) {
                dp[0][j] = value[0];
            }
        }

        //先遍历重量
//        for (int j = 0; j <=maxW; j++) {
//            for (int i = 1; i < weight.length; i++) {
//                if (j < weight[i]) {
//                    dp[i][j] = dp[i-1][j];
//                }else {
//                    dp[i][j] =  Math.max(dp[i-1][j],dp[i][j-weight[i]]+value[i]);
//                }
//            }
//        }

        //先遍历物品
//        for (int i = 1; i < weight.length; i++) {
//            for (int j = 0; j <= maxW ; j++) {
//                if (j < weight[i]) {
//                    dp[i][j] = dp[i-1][j];
//                }else {
//                    dp[i][j] =  Math.max(dp[i-1][j],dp[i][j-weight[i]]+value[i]);
//                }
//            }
//        }

        //先遍历重量
        for (int i = 1; i < weight.length; i++) {
            for (int j = maxW; j >=  weight[i] ; j--) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] =  Math.max(dp[i-1][j],dp[i][j-weight[i]]+value[i]);
                }
            }
        }


        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j]+",");
            }
            System.out.println();
        }

        return dp[weight.length-1][maxW];

    }

    public static int getValue2(int[] weight, int[] value, int maxW) {
        int[] dp = new int[maxW+1];


        //从左到右,物品重复使用
//        for (int i = 0; i < weight.length; i++) {
//            for (int j = 0; j <= maxW; j++) {
//                if (j >= weight[i]) {
//                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
//                }
//            }
//        }


        for (int i = 0; i < weight.length; i++) {
            for (int j = maxW; j >= weight[i]; j--) {
                if (j >= weight[i]) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }





        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i]+",");
        }

        return dp[maxW];

    }
}
