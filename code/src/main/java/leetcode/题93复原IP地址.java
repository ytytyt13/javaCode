package leetcode;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang
 * 2021年07月03日 20:58:00
 */
public class 题93复原IP地址 {
    public static void main(String[] args) {
        List<String> strings = restoreIpAddresses("25525511135");
        strings.forEach(System.out::println);
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        getRes(s,0,res,temp);
        return res;
    }

    public static void getRes(String s, int index ,List<String> res , List<String> temp) {
        if (temp.size() > 4) {
            return;
        }
        if (temp.size() >=4 && index != s.length()) {
            return;
        }
        if (temp.size() == 4) {
            res.add(String.join(".",temp));
            return;
        }

        int num = 0;
        for (int i = index; i <index+3 && i < s.length(); i++) {
            num = num * 10 + s.charAt(i) - '0';
            if (num > 255 || (i>index &&s.substring(index,i+1).startsWith("0"))) {
                break;
            }
            temp.add(String.valueOf(num));
            getRes(s, i + 1, res, temp);
            temp.remove(temp.size() - 1);

        }

    }
}
