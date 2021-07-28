/**
 * @author yang
 * 2021年05月11日 22:39:00
 */
public class 题32母牛问题 {
    public static void main(String[] args) {
        System.out.println(getSum(4));
    }

    public static int getSum(int n) {
        if (n < 4) {
            return n;
        }
        return getSum(n-1)+getSum(n-3);
    }
}
