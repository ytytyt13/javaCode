package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yang
 * 2021年07月18日 20:38:00
 */
public class 题22括号生成 {
    public static void main(String[] args) {

    }

    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return null;
        }
        LinkedList<LinkedList<String>> dp = new LinkedList<LinkedList<String>>();
        LinkedList<String> list0 = new LinkedList<>();
        list0.add("");
        dp.add(list0);
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("()");
        dp.add(list1);

        for (int i = 2; i <=n; i++) {
            LinkedList<String> list = new LinkedList<>();
            for (int j = 0; j <i; j++) {
                LinkedList left = dp.get(j);
                LinkedList right = dp.get(i-j-1);
                for (int k = 0; k < left.size(); k++) {
                    for (int l = 0; l < right.size(); l++) {
                        String s= "("+left.get(k)+")"+right.get(l);
                        list.add(s);
                    }
                }
            }
            dp.add(list);
        }
        return dp.get(n);
    }
}
