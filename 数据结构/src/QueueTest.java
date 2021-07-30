import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yang
 * 2021年07月30日 11:31:00
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.add(2);
        queue.remove();
        System.out.println(queue.poll());
    }
}
