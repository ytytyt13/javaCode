import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

/**
 * @author yang
 * 2021年04月13日 20:34:00
 */
public class get请求aaa {
    public static void main(String[] args) throws IOException {
        while (true) {
            //1.打开浏览器
            CloseableHttpClient httpClient = HttpClients.custom().addInterceptorFirst(new HttpResponseInterceptor() {
                @Override
                public void process(HttpResponse response, HttpContext context) throws HttpException, IOException {
                    HttpEntity resEntity = response.getEntity();
                    // 在此处消费InputStream
                    System.out.println(resEntity.getContent());
                    BufferedInputStream ins = new BufferedInputStream(resEntity.getContent());
//

                    String result = getStringFromResponseStream(ins,"UTF-8");
                    System.out.println(result);
                }
            }).build();


            //2.声明get请求
            String url = "http://vsps.corp.qunar.com/shop/directory/select.json?supplierId=3650805796&appcode=vs_vacation_api";
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(httpGet);
//          CloseableHttpClient httpclient = HttpClients.custom().addInterceptorFirst(new HttpResponseInterceptor() {
            //5.关闭资源
            response.close();
            httpClient.close();
        }
    }

    private static String getHTMLContent(InputStream in) {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        try {
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    private static String getStringFromResponseStream(InputStream is, String charSet)
            throws java.io.IOException, java.io.UnsupportedEncodingException {
        char[] buffer = new char[4096];
        if (is != null) {
            StringBuilder sb = new StringBuilder(4096);
            InputStreamReader reader = new InputStreamReader(is,charSet);
            while (true) {
                int len = reader.read(buffer);
                if (len <= 0) {
                    break;
                }
                sb.append(buffer,0,len);
            }
            return sb.toString();
        }
        return null;
    }
}
