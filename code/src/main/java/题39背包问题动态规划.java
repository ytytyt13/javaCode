/**
 * @author yang
 * 2021年05月15日 13:02:00
 */
public class 题39背包问题动态规划 {
    public static void main(String[] args) {
        int[] W = {3, 4, 3, 6,1};
        int[] V = {3, 5, 2, 1,6};
        getMaxValue(W,V,7);
    }

    public static void  getMaxValue(int[] W, int[] V,int maxW) {
        int[][] help = new int[W.length][maxW+1];
        for (int i = 0; i < W.length; i++) {
            help[i][0] = 0;
        }
        for (int i = 0; i <= maxW; i++) {
            int tempW = i;
            while (W[0] <= tempW && tempW > 0) {
                help[0][i] =V[0];
                tempW -= W[0];
            }
        }

        for (int i = 0; i < help.length; i++) {
            for (int j = 0; j <= maxW; j++) {
                System.out.print(help[i][j]);
            }
            System.out.println();
        }

        for (int i = 1; i < W.length; i++) {
            for (int j = 0; j <= maxW ; j++) {
                if (j < W[i]) {
                    help[i][j] = help[i-1][j];
                }else {
                    help[i][j] = Math.max(help[i-1][j],help[i][j-W[i]]+V[i]);
                }
            }
        }


        for (int i = 0; i < help.length; i++) {
            for (int j = 0; j <= maxW; j++) {
                System.out.print(help[i][j]);
            }
            System.out.println();
        }


        System.out.println(help[W.length-1][maxW]);



    }
}
