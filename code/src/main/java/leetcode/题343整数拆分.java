package leetcode;

/**
 * @author yang
 * 2021年06月17日 21:23:00
 */
public class 题343整数拆分 {
    public static void main(String[] args) {

        System.out.println(integerBreak(3));

    }

    public static int integerBreak(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 2;
        if (n <= 2) {
            return n;
        }
        for(int i = 3; i <= n; i++){
            for(int j = 1; j < i; j++){
                nums[0] = (i - j >= nums[i - j] ? i - j : nums[i - j]) * j ;
                nums[i] = nums[i] >= nums[0] ? nums[i] : nums[0];
            }
        }
        return nums[n];
    }
}
