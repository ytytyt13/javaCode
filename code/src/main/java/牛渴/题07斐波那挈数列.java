package 牛渴;

/**
 * @author yang
 * 2021年04月11日 19:19:00
 */
public class 题07斐波那挈数列 {
    public static void main(String[] args) {
        System.out.println(new 题07斐波那挈数列().Fibonacci(4));
    }

    public int Fibonacci(int n) {
        if (n < 2) {
            return n;
        }

        int sum = 0;
        int before1 = 0;
        int before2 = 1;
        for (int i = 2; i <= n; i++) {
            sum = before1 +before2;
            before1 =before2;
            before2 =sum;
        }
        return sum;
    }
}
