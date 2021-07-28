package leetcode;

/**
 * @author yang
 * 2021年07月18日 21:37:00
 */
public class 题34在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        int[] ints = searchRange(arr, 2);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length < 1) {
            return new int[]{-1,-1};
        }
        int getfirst = getfirst(nums, target, true);
        if (getfirst == -1) {
            return new int[]{-1,-1};
        }
        int getfirst1 = getfirst(nums, target, false);
        return new int[]{getfirst,getfirst1};
    }

    public static int getfirst(int[] nums, int target,boolean flag) {
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = left+right;
            if (flag) {
                mid =(mid)/2;
            }else {
                mid = (mid+1)/2;
            }
            if (nums[mid] > target) {
                right = mid -1;
            }else if (nums[mid] < target) {
                left = mid+1;
            }else {
                if (flag) {
                    right = mid;
                }else {
                    left = mid;
                }
            }
        }

        if (nums[left] == target) {
                return left;
        }
        return -1;
    }

}
