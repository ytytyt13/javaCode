package leetcode;

/**
 * @author yang
 * 2021年07月10日 18:33:00
 */
public class 题36进制加法 {
    public static void main(String[] args) {

    }


    public static String sum(String s1, String s2) {
        int carry = 0;
        int  i = s1.length()-1;
        int j = s2.length()-1;
        int x= 0,y=0;
        String res = "";
        while(i>=0 || j >=0 || carry!= 0) {

            x = i >= 0 ? getInt(s1.charAt(i)) : 0;
            y = j >= 0 ? getInt(s2.charAt(j)) : 0;
            int temp = x + y + carry;
            res += ('0' + temp / 36);
            carry = temp % 36;
            i--;
            j--;
        }

        StringBuilder stringBuilder = new StringBuilder(res);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }


    public static char getChar(int num) {
        if (num <= 9) {
            return (char) ('0' + num);
        } else{
            return (char)('a'+num);
        }
    }

    public static int getInt(char ch) {
        if (ch >= '0' && ch <= '9') {
            return ch-'0';
        }else {
            return ch-'a';
        }
    }
}
