package leetcode;

/**
 * @author yang
 * 2021年07月18日 20:55:00
 */
public class 题468验证IP地址 {
    public static void main(String[] args) {
        String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        System.out.println(validIPAddress(ip));
    }

    public static String validIPAddress(String IP) {
        if (IP == null) {
            return "Neither";
        }

        if (IP.contains(".")) {
            if (isIPV4(IP)) {
                return "IPv4";
            }
        }else if (isIPV6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    public static boolean isIPV4(String IP){
        int num = 0;
        int left = 0;
        int right = 0;
        int time = 0;
        while (right< IP.length()) {
            if (IP.charAt(right) == '.' || right == IP.length()-1) {
                time ++;
                if (time > 4) {
                    return false;
                }
                String substring = IP.substring(left, right);
                if (substring == "") {
                    return false;
                }
                if (substring.length() > 1 && substring.charAt(0) == '0') {
                    return false;
                }
                for (int i = 0; i < substring.length(); i++) {
                    if (!(substring.charAt(i)>='0' && substring.charAt(i)<='9')){
                        return false;
                    }
                    num = num*10+substring.charAt(i)-'0';
                    if (num > 255) {
                        return false;
                    }
                }
                left = right+1;
            }
            right++;
            num = 0;
        }

        return true;
    }

    public static Boolean isIPV6(String IP){
        int left = 0;
        int right = 0;
        int time = 0;

        while (right < IP.length()) {
            if (IP.charAt(right) == ':') {
                time++;
                if (time > 8) {
                    return false;
                }
                String substring = IP.substring(left, right);
                if (substring == "") {
                    return false;
                }
                if (substring.length()>4) {
                    return false;
                }
                for (int i = 0; i < substring.length(); i++) {
                    char c= substring.charAt(i);
                    if (!((c >= '0' && c <='9') || (c >= 'a'&& c <='f') || (c >= 'A' && c <= 'F'))) {
                        return false;
                    }
                }
                left = right+1;
            }
            right++;
        }

        return true;

    }
}
