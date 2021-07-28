package leetcode;

/**
 * @author yang
 * 2021年06月12日 19:22:00
 */
public class 题53最大子序和 {
    public static void main(String[] args) {
        int[] arr ={-2,-1};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1){
            return 0;
        }
        int res = -Integer.MAX_VALUE;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp +=  nums[i];
            if (temp > res) {
                res = temp;
            }
            if (temp < 0) {
                temp = 0;
            }
        }
        return res;
    }
}
