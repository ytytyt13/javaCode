/**
 * @author yang
 * 2021年05月10日 23:10:00
 */
public class 题31打印字符串的全排列 {
    public static void main(String[] args) {
        process("abc".toCharArray(),0);
    }

    public static void process(char[] ch,int n) {
        if (n == ch.length) {
            System.out.println(new String(ch));
        }else {
            for (int i = n; i < ch.length; i++) {
                swap(ch,n,i);
                process(ch, n+1);
                swap(ch,n,i);
            }
        }
    }

    public static void swap(char[] ch ,int i ,int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
