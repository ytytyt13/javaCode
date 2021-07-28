/**
 * @author yang
 * 2021年05月10日 22:54:00
 */
public class 题30打印字符串所有的子序列 {
    public static void main(String[] args) {
        printAllSub("abc".toCharArray(),0,"");
    }

    public static void printAllSub(char[] ch,int i, String res) {
        if (i >= ch.length) {
            System.out.println(res);
        }else {
            printAllSub(ch,i+1, res+ch[i]);
            printAllSub(ch,i+1, res);
        }
    }


}
