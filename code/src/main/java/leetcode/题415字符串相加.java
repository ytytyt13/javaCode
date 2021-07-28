package leetcode;

import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author yang
 * 2021年06月12日 20:08:00
 */
public class 题415字符串相加 {
    private static final char ZERO = '0';
    public static void main(String[] args) {
        String num1 = "6";
        String num2 = "501";
        System.out.println(addStrings(num1, num2));
    }

    public static String addStrings(String num1, String num2) {
        if (num1 == null) {
            return num2;
        }
        if (num2 == null) {
            return num1;
        }
        int temp = 0;
        Stack<Integer> st =new Stack<>();
        int i = 0;
        for ( ;i < Math.min(num1.length(), num2.length()); i++) {
            Integer n1 = (int)num1.charAt(num1.length() - 1 - i) - ZERO;
            Integer n2 = (int)num2.charAt(num2.length() - 1 - i) - ZERO;
            int sum = n1+n2+temp;
            temp = sum / 10;
            sum = sum % 10;

            st.push(sum);
        }

        for (;i<num1.length();i++) {
            Integer n1 = (int)num1.charAt(num1.length() - 1 - i) - ZERO;
            int sum = n1+temp;
            temp = sum / 10;
            sum = sum % 10;
            st.push(sum);
        }

        for (;i<num2.length();i++) {
            Integer n2 = (int)num2.charAt(num2.length() - 1 - i) - ZERO;
            int sum = n2+temp;
            temp = sum / 10;
            sum = sum % 10;
            st.push(sum);
        }

        if (temp != 0) {
            st.push(temp);
        }

        StringBuffer stringBuffer = new StringBuffer();
        while(!st.isEmpty()) {
            stringBuffer.append(st.pop());
        }

        return stringBuffer.toString();

    }
}
