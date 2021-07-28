package 牛渴;

/**
 * @author yang
 * 2021年04月11日 21:16:00
 */
public class 题13奇数往前移 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        new 题13奇数往前移().reOrderArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }



    public int[] reOrderArray (int[] array) {
        // write code here
        if (array == null || array.length < 2)
            return array;
        for (int i = 1; i < array.length; i++) {
            if (array[i]%2 == 1) {
                for (int j = i; j > 0 ; j--) {
                    if (array[j-1]%2 == 1) {
                        break;
                    }else {
                        int temp = array[j];
                        array[j] = array[j-1];
                        array[j-1] = temp;
                    }
                }
            }
        }
        return array;
    }


}
