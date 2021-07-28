import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author yang
 * 2021年05月09日 21:09:00
 */
public class 题26利益最大化 {
    public static void main(String[] args) {
        int[] cost = {100,200,50};
        int[] profit = {10,30,15};
        int money = 100;
        int k = 2;
        System.out.println(getMaxProfit(cost, profit, k, money));


    }
    public static class Node {
        public int cost;
        public int profit;
        public Node(int cost, int profit){
            this.cost = cost;
            this.profit = profit;
        }
    }

    public static class minCompartor implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost - o2.cost;
        }
    }

    public static class maxComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.profit - o1.profit;
        }
    }

    public static int getMaxProfit(int[] cost, int[] profit ,int k, int w ) {
        Node[] nodes = new Node[profit.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(cost[i], profit[i]);
        }
        PriorityQueue<Node> nodes1 = new PriorityQueue<>(new minCompartor());
        PriorityQueue<Node> nodes2 = new PriorityQueue<>(new maxComparator());
        for (int i = 0; i < nodes.length; i++) {
            nodes1.add(nodes[i]);
        }

        for (int i = 0; i < k; i++) {
            while (!nodes1.isEmpty() && nodes1.peek().cost < w) {
                nodes2.add(nodes1.poll());
            }
            if (nodes2.isEmpty()) {
                return w;
            }
            w += nodes2.poll().profit;
        }

        return w;


    }




}
