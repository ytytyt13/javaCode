package leetcode;

/**
 * @author yang
 * 2021年06月20日 17:20:00
 */
public class 题5最长回文子串 {
    public static void main(String[] args) {

        String s  = "babad";
        System.out.println(longestPalindrome2(s));
    }
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder("#");
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }

        String st = sb.toString();
        String res = String.valueOf(s.charAt(0));
        for (int i = 1; i < st.length(); i++) {
            left = i -1;
            right = i +1;
            while (left >= 0 && right < st.length() && st.charAt(left) == st.charAt(right)) {
                left --;
                right ++;
            }
            if(((right- left- 1)/2) > res.length()){
                res = s.substring((left+1)/2,(right-1)/2);
            }
        }

        return res;
    }

    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return null;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        String res = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i -j < 2){
                        dp[j][i] = true;
                    }else if (dp[j+1][i-1]) {
                        dp[j][i] = true;
                    }else {
                        dp[j][i] =false;
                    }
                }
                if (dp[j][i] && (i-j+1) > res.length()) {
                    res = s.substring(j,i+1);
                }
            }
        }

        return res;
    }
}
