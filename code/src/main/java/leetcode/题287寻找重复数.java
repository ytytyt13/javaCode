package leetcode;

/**
 * @author yang
 * 2021年07月23日 21:34:00
 */
public class 题287寻找重复数 {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.out.println(findDuplicate(arr));
    }

    public static int findDuplicate(int[] nums) {
        if (nums == null|| nums.length <1) {
            return 0;
        }

        int fast= 0;
        int slow = 0;
        while(fast < nums.length) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) {
                break;
            }
        }
        fast = 0;
        while (fast != slow) {
            fast= nums[fast];
            slow = nums[slow];
        }

        return slow;
    }
}
