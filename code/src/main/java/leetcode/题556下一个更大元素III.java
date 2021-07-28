package leetcode;

import java.util.Arrays;

/**
 * @author yang
 * 2021年07月22日 22:29:00
 */
public class 题556下一个更大元素III {
    public static void main(String[] args) {
        System.out.println(nextGreaterElement(12));
    }
    public static int nextGreaterElement(int n) {
        if (n==0) {
            return 0;
        }
        String s = n+"";
        char[] chars = s.toCharArray();
        for (int i = s.length()-1; i >=0 ; i--) {
            if (i==0) {
                return -1;
            }else {
                if (chars[i] > chars[i-1]){
                    Arrays.sort(chars,i,chars.length);
                    for (int j = i; j < chars.length; j++) {
                        if (chars[j] > chars[i-1]) {
                            char temp = chars[i-1];
                            chars[i-1] = chars[j];
                            chars[j] = temp;
                            int res = 0;
                            for (int x = 0; x < chars.length; x++) {
                                res = res*10+(chars[x]-'0');
                            }
                            return res;
                        }
                    }
                }
            }
        }

        return -1;
    }
}
