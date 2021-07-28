import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yang
 * 2021年04月22日 22:45:00
 */
public class 算法11队列实现栈 {
    public static void main(String[] args) {
        算法10数组结构实现栈.Stack1 stack = new 算法10数组结构实现栈.Stack1(5);
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(7);
        stack.push(8);
        System.out.println(stack.peek());
    }


    public static class Stack2 {
        private Queue<Integer> data;
        private Queue<Integer> help;

        public Stack2() {
            data = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(int num) {
            data.add(num);
        }

        public int pop() {
            if (data.isEmpty()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            while (data.size() > 1) {
                help.add(data.poll());
            }

            int res = data.poll();
            Queue temp = data;
            data = help;
            help = temp;
            return res;
        }

        public int peek() {
            if (data.isEmpty()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            while (data.size() > 1) {
                help.add(data.poll());
            }

            int res = data.peek();
            help.add(data.poll());
            Queue temp = data;
            data = help;
            help = temp;
            return res;

        }
    }
}

