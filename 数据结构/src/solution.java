import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yang
 * 2021年03月06日 12:44:00
 */

import java.util.*;

public class solution {
    static String[] one = {",", "."};
    static String[] two = {"a", "b", "c"};
    static String[] thr = {"d", "e", "f"};
    static String[] fou = {"g", "h", "i"};
    static String[] fiv = {"j", "k", "l"};
    static String[] six = {"m", "n", "o"};
    static String[] sev = {"p", "q", "r", "s"};
    static String[] ent = {"t", "u", "v"};
    static String[] nig = {"w", "x", "y", "z"};
    static String zer = " ";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String n = sc.nextLine();
            String[] c = n.split("#");
            StringBuffer re = new StringBuffer();
            for (int i = 0; i < c.length; i++) {
                if (i % 2 == 1) {
                    get(re, c[i]);
                } else {
                    re.append(c[i]);
                }
            }

            System.out.println(re.toString());
        }
    }

    private static StringBuffer get(StringBuffer re, String c) {
        String[] s = c.split("/");
        int x = -1;
        for (String a : s) {
            char[] ch = a.toCharArray();
            for (int m = 0; m < ch.length; m++) {
                if (String.valueOf(ch[m]).equals("1")) {
                    x++;
                    if (m == ch.length-1 || !String.valueOf(ch[m + 1]).equals("1")) {
                        if(x>one.length-1) x = x % one.length;
                        re.append(one[x]);
                        x = -1;
                    }
                }
                if (String.valueOf(ch[m]).equals("2")) {
                    x++;
                    if (m == ch.length-1 || !String.valueOf(ch[m + 1]).equals("2")) {
                        if(x>two.length-1) x = x % two.length;
                        re.append(two[x]);
                        x = -1;
                    }

                }
                if (String.valueOf(ch[m]).equals("3")) {
                    x++;
                    if (m == ch.length-1 || !String.valueOf(ch[m + 1]).equals("3")) {
                        if(x>thr.length-1) x = x % thr.length;
                        re.append(thr[x]);
                        x = -1;
                    }

                }
                if (String.valueOf(ch[m]).equals("4")) {
                    x++;
                    if (m == ch.length-1 || !String.valueOf(ch[m + 1]).equals("4")) {
                        if(x>fou.length-1) x = x % fou.length;
                        re.append(fou[x]);
                        x = -1;
                    }

                }
                if (String.valueOf(ch[m]).equals("5")) {
                    x++;
                    if (m == ch.length-1 || !String.valueOf(ch[m + 1]).equals("5")) {
                        if(x>fiv.length-1) x = x % fiv.length;
                        re.append(fiv[x]);
                        x = -1;
                    }

                }
                if (String.valueOf(ch[m]).equals("6")) {
                    x++;
                    if (m == ch.length-1 || !String.valueOf(ch[m + 1]).equals("6")) {
                        if(x>six.length-1) x = x % six.length;
                        re.append(six[x]);
                        x = -1;
                    }

                }
                if (String.valueOf(ch[m]).equals("7")) {
                    x++;
                    if (m == ch.length-1 || !String.valueOf(ch[m + 1]).equals("7")) {
                        if(x>sev.length-1) x = x % sev.length;
                        re.append(sev[x]);
                        x = -1;
                    }

                }
                if (String.valueOf(ch[m]).equals("8")) {
                    x++;
                    if (m == ch.length-1 || !String.valueOf(ch[m + 1]).equals("8")) {
                        if(x>ent.length-1) x = x % ent.length;
                        re.append(ent[x]);
                        x = -1;
                    }

                }
                if (String.valueOf(ch[m]).equals("9")) {
                    x++;
                    if (m == ch.length-1 || !String.valueOf(ch[m + 1]).equals("9")) {
                        if(x>nig.length-1) x = x % nig.length;
                        re.append(nig[x]);
                        x = -1;
                    }

                }
                if (String.valueOf(ch[m]).equals("0")) {
                    re.append(zer);
                }
            }
        }
        return re;
    }
}



