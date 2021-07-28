package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yang
 * 2021年07月25日 13:37:00
 */
public class 题670最大交换 {
    public static void main(String[] args) {
        int num = 2736;
        System.out.println(maximumSwap(num));
    }

    public static int maximumSwap(int num) {
        Stack<Integer> st = new Stack<>();
        List<Integer> help = new ArrayList<>();
        int n = num;
        while(n >0){
            st.push(n%10);
            n = n/10;
        }
        while(!st.isEmpty()) {
            help.add(st.pop());
        }
        int low=0,high = 0,max = 0,maxloc=0;
        for (int i = help.size()-1; i >=0 ; i--) {
            if (help.get(i) > max) {
                maxloc = i;
                max = help.get(i);
            }else if (help.get(i) < max){
                low = i;
                high = maxloc;
            }
        }

        int temp = help.get(low);
        help.set(low,help.get(high));
        help.set(high,temp);

        int res = help.get(0);
        for (int i = 1; i < help.size(); i++) {
            res = res*10+help.get(i);
        }
        return res;
    }
}
