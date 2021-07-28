/**
 * @author yang
 * 2021年04月11日 17:07:00
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class 调整数组中的数据位置 {
    public static void main(String[] args) {
        String[] arr={"a","1","b","2","c","3","d"};

        //冒泡的方式
        for (int i = 2; i < arr.length; i+=2) {
            int swaptimes = i>>1;
            swap(arr,i,swaptimes);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void swap(String[] arr,int begin, int times) {
        for (int i = 0; i < times; i++) {
            String temp= arr[begin];
            arr[begin]=arr[begin-1];
            arr[begin-1]=temp;
            begin--;
        }
    }

}
