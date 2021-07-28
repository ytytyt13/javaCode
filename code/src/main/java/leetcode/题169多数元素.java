package leetcode;

/**
 * @author yang
 * 2021年07月03日 17:01:00
 */
public class 题169多数元素 {
    public static void main(String[] args) {

        int[] num = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(num));
    }
//1.hashmap计数法

//排序取中间发

//摩尔计数发
    public static int majorityElement(int[] nums) {
        int flag = nums[0];
        int sum = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == flag) {
                sum++;
            }else {
                sum--;
                if (sum < 1) {
                    flag = nums[i];
                    sum = 1;
                }
            }
        }

        return flag;

    }
}
