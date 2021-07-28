/**
 * @author yang
 * 2021年05月13日 22:01:00
 */
public class 题38背包问题暴力解法 {

    private static int maxV = 0;
    private static int c = 7;
    public static void main(String[] args) {
        int[] W = {3,4,3,6};
        int[] V = {3,5,2,2};
        getMaxValue(W,V,0,0,0);
        System.out.println(maxV);
    }

    public static void  getMaxValue(int[] W, int[] V,int curW,int curV,int index) {
        if (index >= W.length -1 ){

            System.out.println(curV +","+curW);
            if (curW <= c && curV > maxV) {
                maxV = curV;
            }
            return;
        }

        getMaxValue(W,V,curW+W[index],curV +V[index],index+1);
        getMaxValue(W,V,curW,curV,index+1);
    }
}
