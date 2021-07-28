import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;

import java.io.IOException;

/**
 * @author yang
 * 2021年04月13日 20:34:00
 */
public class get请求 {
    public static void main(String[] args) throws IOException {
        while (true) {
            //1.打开浏览器
            CloseableHttpClient httpClient = new DefaultHttpClient();

            //2.声明get请求
            String url = "http://vsps.corp.qunar.com/shop/directory/select.json?supplierId=3650805796&appcode=vs_vacation_api";
            HttpGet httpGet = new HttpGet(url);

            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(1000).setConnectionRequestTimeout(1000)
                    .setSocketTimeout(2000).build();
            httpGet.setConfig(requestConfig);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            //4.判断状态码
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                //使用工具类EntityUtils，从响应中取出实体表示的内容并转换成字符串
                String string = EntityUtils.toString(entity);
                System.out.println(string);
            }

            //5.关闭资源
            response.close();
            httpClient.close();
        }
    }
}
