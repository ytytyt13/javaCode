/**
 * @author yang
 * 2021年04月25日 13:16:00
 */
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestCurl {


    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        String url = "https://touch.dujia.qunar.com/golfz/shop/shopDirectory?shopDirectories=%E4%BA%91%E5%8D%97-*&eachRows=0%2C100&groupRows=3%2C3&modules=list&supplierEnids=3650805796";


        while(true) {
            System.out.println(execCurl(url));
        }

    }


    public static String execCurl(String url) {
        String[] cmds={"curl","--connect-timeout","0","-m","2",url};
        ProcessBuilder process = new ProcessBuilder(cmds);
        Process p;
        try {
            p = process.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
            return builder.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return StringUtils.EMPTY;
    }
}

