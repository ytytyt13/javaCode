package leetcode;

/**
 * @author yang
 * 2021年06月22日 20:58:00
 */
public class 题41缺失的第一个正数 {
    public static void main(String[] args) {
        int[] arr ={1,2};
        System.out.println(firstMissingPositive(arr));

    }

    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 1;
        }

        boolean flag =false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                flag = true;
            }
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }
        if (!flag) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            int n = Math.abs(nums[i])-1;
            nums[n] = -Math.abs(nums[n]);
        }

        int i= 0;
        for (; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
        }
        return i+1;
    }
}
