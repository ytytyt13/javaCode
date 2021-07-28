/**
 * @author yang
 * 2021年05月18日 21:54:00
 */
public class 题40KMP {
    public static void main(String[] args) {
        System.out.println(isInclude("abcdefggshsf", "efg"));
        System.out.println(isClude2("agsdfjksdshdfh","sds"));
    }

    public static int[] getNext(String str) {
        if (str.length() == 1) {
            return new int[]{-1};
        }
        int[] next = new int[str.length()];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < str.length()) {
            if (str.charAt(cn) == str.charAt(i-1)) {
                next[i++] = ++cn;
            }else if(cn > 0){
                cn = next[cn];
            }else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static boolean isClude2(String s, String m) {
        int i1 = 0;
        int i2 = 0;

        int[] next = getNext(m);

        while (i1 < s.length() && i2 < m.length()) {
            if (s.charAt(i1) == m.charAt(i2)) {
                i1++;
                i2++;
            }else {
                if (next[i2] == -1) {
                    i1++;
                }else {
                    i2= next[i2];
                }
            }
        }
        if (i2 == m.length()) {
            return true;
        }

        return false;

    }

    public static boolean isInclude(String a1,String a2) {
        if (a1 == null ||a2 == null || a1.length() ==0 || a2.length() == 0 || a1.length() < a2.length()) {
            return false;
        }

        for (int i = 0; i < a1.length(); i++) {
            int a= i;
            for (int j = 0; j < a2.length(); j++) {
                System.out.println(a+","+j);
                if (a1.charAt(a) == a2.charAt(j)) {
                    if (j == a2.length() -1 ) {
                        return true;
                    }
                    a++;
                }else {
                    break;
                }
            }
        }
        return false;
    }
}
