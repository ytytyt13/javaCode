import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yang
 * 2021年05月09日 20:43:00
 */
public class 题24最小字符组合 {
    public static void main(String[] args) {
        String[]  strs = {"a","c","b","g","e","f"};
        System.out.println(lowerString(strs));
    }

    public static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return (o1+o2).compareTo(o2+o1);
        }

    }

    public static String lowerString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs,new MyComparator());
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res+=strs[i];
        }
        return res;
    }
}
