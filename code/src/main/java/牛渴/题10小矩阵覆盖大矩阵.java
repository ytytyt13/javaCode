package 牛渴;

/**
 * @author yang
 * 2021年04月11日 19:59:00
 */
public class 题10小矩阵覆盖大矩阵 {

    public static void main(String[] args) {
        System.out.println(new 题10小矩阵覆盖大矩阵().rectCover(4));
    }

    public int rectCover(int target) {
        return getNum(target);
    }

    public int getNum(int n) {
        if (n <0 ) {
            return 0;
        }
        if (n <= 3){
            return n;
        }

        return getNum(n-1)+getNum(n-2);
    }

    public int[] reOrderArray (int[] array) {
        // write code here
        if (array.length<3) {
            return array;
        }

        for(int i=2;i<array.length;i+=2) {
            int times = i/2;
            swap(array,i,times);

        }
        return array;
    }

    public void swap(int[] arr ,int b, int t) {
        for(int i= 0;i<t;t++) {
            int temp = arr[b-1];
            arr[b-1]=arr[b];
            arr[b]=temp;
            b--;
        }
    }
}
