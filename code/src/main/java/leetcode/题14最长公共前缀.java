package leetcode;

import com.sun.jmx.snmp.SnmpUnknownMsgProcModelException;

/**
 * @author yang
 * 2021年07月25日 16:24:00
 */
public class 题14最长公共前缀 {
    public static void main(String[] args) {

        String[] strs = {"flaez","flaee","flaee"};
        System.out.println(longestCommonPrefix(strs));

    }

    public static String longestCommonPrefix(String[] strs) {
        int index = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i< strs.length;i++) {
            if (strs[i].length() < min) {
                min = strs[i].length();
            }
        }
        boolean flag = true;
        String res = "";
        while(index < min && flag) {
            char c = strs[0].charAt(index);
            for (int i = 1; i < strs.length ; i++) {
                if (strs[i].charAt(index) != c) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                res+=c;
            }
            index++;
        }

        return res;
    }
}
