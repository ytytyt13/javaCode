import java.util.NoSuchElementException;

/**
 * @author yang
 * 2021年04月22日 22:25:00
 */
public class 算法10数组结构实现栈 {

    public static void main(String[] args) {

        Stack1 stack = new Stack1(5);
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


    public static class Stack1 {
        private int size;
        private int index;
        private int[] arr;

        public Stack1(int n){
            if (n < 0){
                throw new IllegalArgumentException();
            }
            arr = new int[n];
            index=0;
            size =n;
        }

        public void push(int num) {
            if(index >= size) {
                throw new ArrayIndexOutOfBoundsException();
            }
            arr[index++] = num;
        }

        public int pop(){
            if(index<0) {
                throw new NoSuchElementException();
            }
            return arr[--index];
        }

        public int peek(){
            if(index < 0) {
                throw new NoSuchElementException();
            }
            return arr[index-1];
        }
    }
}
