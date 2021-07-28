import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author yang
 * 2021年05月12日 21:49:00
 */
public class 题36背包最大价值问题 {

    public static void main(String[] args) {
        int[] Ws = {35,30,50,10,25};
        int[] Vs = {10,40,50,40,30};
        int wight = 150;

        Book[] books = new Book[Ws.length];
        for (int i = 0; i < Ws.length; i++) {
            books[i] = new Book(Ws[i],Vs[i]);
        }

        int value = 0;


        PriorityQueue<Book> books1 = new PriorityQueue<>(new minComparator());
        PriorityQueue<Book> books2 = new PriorityQueue<>(new maxComparator());
        for (int i = 0; i < books.length; i++) {
            books1.add(books[i]);
        }
        while (books1.peek().W < wight) {
            books2.add(books1.poll());
        }

        while (wight > books2.peek().W) {
            wight -= books2.peek().W;
            value += books2.poll().V;
        }

        System.out.println(value);

    }

    public static class Book {

        public int W;
        public int V;


        public Book(int W, int V) {
            this.W = W;
            this.V = V;
        }
    }

    public static class minComparator implements Comparator<Book>{

        @Override
        public int compare(Book o1, Book o2) {
            return o1.W - o2.W;
        }
    }

    public static class maxComparator implements Comparator<Book> {

        @Override
        public int compare(Book o1, Book o2) {
            return o2.V - o1.V;
        }
    }
}
