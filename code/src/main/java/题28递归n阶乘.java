/**
 * @author yang
 * 2021年05月10日 22:31:00
 */
public class 题28递归n阶乘 {
    public static void main(String[] args) {
        System.out.println(getN(4));
    }

    public static long getN(int n) {
        if (n == 1) {
            return 1L;
        }
        return n * getN(n-1);
    }
}
