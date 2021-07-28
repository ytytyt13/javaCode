package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yang
 * 2021年06月28日 22:27:00
 */
public class 题165比较版本号 {
    public static void main(String[] args) {

    }
    public static int compareVersion(String version1, String version2) {
        int len1 = version1.length();
        int len2 = version2.length();
        int p1 = 0;
        int p2 = 0;
        while (p1 < len1 || p2 < len2) {
            int v1 = 0;
            int v2 = 0;
            while (p1 < len1 && version1.charAt(p1) != '.') {
                v1 = v1 * 10 + version1.charAt(p1) - '0';
                p1++;
            }

            while (p2 < len2 && version2.charAt(p2) != '.') {
                v2 = v2 * 10 + version2.charAt(p2) - '0';
                p2++;
            }
            if (v1 > v2) {
                return 1;
            }
            if (v1 < v2) {
                return -1;
            }
            p1++;
            p2++;
        }

        return 0;

    }
}
