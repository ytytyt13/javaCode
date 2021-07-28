/**
 * @author yang
 * 2021年05月24日 21:35:00
 */
public class 题41马拉车算法 {
    public static void main(String[] args) {
        System.out.println(getMaxRound("acbbcafjsdahfjasbgafadgsjbajhfajlagsdhsdgjxhddhshfshgfhssdgdgdgdgdgd"));
    }

    public static int getMaxRound(String str) {
        if (str.length() < 1) {
            return 0;
        }

        String newStr = "#";
        for (int i = 0; i < str.length(); i++) {
            newStr = newStr +str.charAt(i)+"#";
        }
        System.out.println(newStr);

        int max = 0;

        String res = "";

        for (int i = 0; i < newStr.length(); i++) {
            int l = i;
            int r = i;
            while ( l >= 0 && r < newStr.length()) {
                System.out.println(l+","+i+","+r);
                if (newStr.charAt(l) == newStr.charAt(r)) {
                    l--;
                    r++;
                }else {
                    break;
                }
            }
            if (r-l-1 > max) {
                max = r-l-1;
                res = str.substring((l+1)/2,(r-1)/2);
            }

        }

        System.out.println("max"+max);
        System.out.println("res:"+res);
        return max/2;

    }
}
