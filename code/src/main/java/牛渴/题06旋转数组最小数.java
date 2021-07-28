package 牛渴;

/**
 * @author yang
 * 2021年04月11日 19:11:00
 */
public class 题06旋转数组最小数 {
    public static void main(String[] args) {
        int arr[] = {3,4,5,1,2};
        System.out.println(new 题06旋转数组最小数().minNumberInRotateArray(arr));
    }

    public int minNumberInRotateArray(int [] array) {
        if(array == null || array.length <1)
            return 0;

        for (int i = array.length -1; i > 0 ; i--) {
            if (array[i]<array[i-1]){
                return array[i];
            }
        }
        return array[0];
    }
}
