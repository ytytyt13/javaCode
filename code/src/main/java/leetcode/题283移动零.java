package leetcode;

/**
 * @author yang
 * 2021年07月22日 22:47:00
 */
public class 题283移动零 {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void moveZeroes(int[] nums) {
        for (int i = nums.length-1; i >0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] ==0 && nums[j+1] != 0) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] =temp;
                }
            }
        }
    }
}
