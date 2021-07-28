package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yang
 * 2021年07月25日 11:22:00
 */
public class 剑指Offer38字符串的排列 {
    public static void main(String[] args) {
        String a= "suvyls";
        String[] permutation = permutation(a);

        for (int i = 0; i < permutation.length; i++) {
            System.out.println(permutation[i]);
        }
        System.out.println(permutation.length);
    }

    public static String[] permutation(String s) {
        String[]  res = {};
        if (s == null || s.length() < 1) {
            return res;
        }
        char[] chars = s.toCharArray();
        Set<String> list = new HashSet<>();
        getRes(chars,0,list);
        String[] strings = list.toArray(new String[list.size()]);
        return strings;
    }

    public static void getRes(char[] s,int index, Set<String> res) {
        if (index >= s.length - 1) {
            res.add(new String(s));
            return;
        }
        for (int i = index; i < s.length; i++) {
            swap(s,index,i);
            getRes(s,index+1,res);
            swap(s,index,i);
        }

    }

    public static void swap(char[] s,int i,int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
