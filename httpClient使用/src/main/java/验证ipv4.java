import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yang
 * 2021年05月28日 16:40:00
 */
public class 验证ipv4 {

    private static final Pattern IPV4_REGEX =
            Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    public static void main(String[] args) {
        String ip = "127.0.0.1";
        System.out.println(isIPV4(ip));

    }

    public static boolean isIPV4(String ipStr){
        if (StringUtils.isEmpty(ipStr))
            return false;
        Matcher matcher = IPV4_REGEX.matcher(ipStr);
        return matcher.find();
    }
}
