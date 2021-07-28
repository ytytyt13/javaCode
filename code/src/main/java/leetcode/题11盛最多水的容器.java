package leetcode;

/**
 * @author yang
 * 2021年07月24日 18:05:00
 */
public class 题11盛最多水的容器 {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        if (height == null || height.length <1) {
            return maxArea;
        }
        int left = 0;
        int right = height.length-1;
        while(left<right) {
            maxArea = Math.max(maxArea,(right-left)*Math.min(height[left],height[right]));
            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return maxArea;

    }
}
