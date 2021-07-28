import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yang
 * 2021年04月14日 11:03:00
 */
public class post请求 {
    private static final String FILTER_SECCENTER_URL = "http://inspection.corp.qunar.com/inspectcontent/inspecttexts.do?appcode=travelComment";

    public static void main(String[] args) throws IOException {


        //1.打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2.声明post请求
        HttpPost httpPost = new HttpPost(FILTER_SECCENTER_URL);
        //3.添加参数
        //httpPost.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
        httpPost.addHeader("Content-Type", "application/json");
        //4.判断状态码
        List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
        parameters.add(new BasicNameValuePair("text", "三亚"));


        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters,"UTF-8");

        httpPost.setEntity(formEntity);

        //5.发送请求
        CloseableHttpResponse response = httpClient.execute(httpPost);

        if(response.getStatusLine().getStatusCode()==200){
            HttpEntity entity = response.getEntity();
            String string = EntityUtils.toString(entity, "utf-8");
            System.out.println(string);
        }
        //6.关闭资源
        response.close();
        httpClient.close();
    }
}
