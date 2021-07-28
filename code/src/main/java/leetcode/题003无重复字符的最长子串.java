package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yang
 * 2021年05月29日 16:36:00
 */
public class 题003无重复字符的最长子串 {
    public static void main(String[] args) {
        String s= "aabaab!bb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if ( s == null || s.length() < 1){
            return 0;
        }
        int res = 0;
        int left = 0;
        Map<Character,Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if(map.keySet().contains(s.charAt(i))) {
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            res = Math.max(res,i-left+1);
        }

        return res;
    }


}
