import java.util.Stack;

/**
 * @author yang
 * 2021年04月22日 23:00:00
 */
public class 算法12判断链表是否为回文结构 {
    public static void main(String[] args) {
        //使用栈结构

        //走一半,然后逆序后半部分,然后头尾往中间走

        int[] arr = {14,5,5,14,4};
        Stack<Integer> s =new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            s.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != s.pop()){
                System.out.println(false);
            }
        }
        System.out.println(true);
    }
}
