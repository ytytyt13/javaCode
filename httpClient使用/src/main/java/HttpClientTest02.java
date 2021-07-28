/**
 * @author yang
 * 2021年04月25日 13:08:00
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.CoreConnectionPNames;

public class HttpClientTest02 {

    public static void main(String[] args) {
        while(true) {
            test();
        }
    }

    public static void test() {
        String url = "http://vsps.corp.qunar.com/shop/directory/select.json?supplierId=3650805796&appcode=vs_vacation_api";
        HttpClientUtil2 httpClientUtil2 = new HttpClientUtil2();
        String content = httpClientUtil2.getHtml(url);
        System.out.println(content);
    }
}