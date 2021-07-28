package leetcode;

/**
 * @author yang
 * 2021年07月03日 20:19:00
 */
public class 题209长度最小的子数组 {
    public static void main(String[] args) {

        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int res= Integer.MAX_VALUE;
        if (nums == null | nums.length < 1) {
            return res;
        }
        int l = 0,r = 0;
        int sum =nums[0];
        while(l <= r && r < nums.length) {
            if (sum < target && r < nums.length-1) {
                    r++;
                    sum += nums[r];
            }else if (sum >=target){
                res = Math.min(res,r-l+1);
                sum-=nums[l];
                l++;

            }else{
                break;
            }
        }
        return res==Integer.MAX_VALUE?0:res;

    }
}
