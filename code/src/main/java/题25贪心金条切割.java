
import java.util.PriorityQueue;

/**
 * @author yang
 * 2021年05月09日 20:53:00
 */
public class 题25贪心金条切割 {
    public static void main(String[] args) {
        int[] arr = {10,20,30};
        System.out.println(getMinHeap(arr));

    }

    public static int getMinHeap(int[] arr) {
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        if (arr == null || arr.length ==0) {
            return 0;
        }
        for (int i = 0; i < arr.length; i++) {
            integers.add(arr[i]);
        }
        int cur = 0;
        int sum = 0;
        while(integers.size() > 1) {
            cur = integers.poll() + integers.poll();
            sum += cur;
            integers.add(cur);
        }
        return sum;
    }
}
