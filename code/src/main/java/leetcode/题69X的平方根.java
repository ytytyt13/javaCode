package leetcode;

/**
 * @author yang
 * 2021年06月16日 22:17:00
 */
public class 题69X的平方根 {
    public static void main(String[] args) {

        System.out.println(mySqrt(6));
    }

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left =1;
        int right = x/2;
        while (left <= right) {
            System.out.println(left+","+right);
            int mid = (right + left)/2;
            long temp = (long)mid *(long)mid;
            System.out.println(temp);
            if (temp == x) {
                return mid;
            }
            if (temp > x) {
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static int mySqrt2(int x) {
       double a = x;
       double res = (a + x/a)/2;

       //不断的向下逼近,知道当a不变化
       while (res != a) {
           a = res;
           res = (a + x/a)/2;
       }
       return (int)a;
    }
}
