package 牛渴;

/**
 * @author yang
 * 2021年04月11日 18:21:00
 */
public class 题01二维数组找数 {
    public static void main(String[] args) {

        int[][] arr={{1,2,8,9}, {2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int t =7;
        System.out.println(new 题01二维数组找数().Find(t,arr));
    }

    public boolean Find(int target, int [][] array) {
        if (array == null || array.length < 1)
            return false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > target )
                    break;
                else if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}


