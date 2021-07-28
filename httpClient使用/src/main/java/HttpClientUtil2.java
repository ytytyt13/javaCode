/**
 * @author yang
 * 2021年04月25日 15:21:00
 */

import com.beust.jcommander.internal.Maps;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tingtingcao on 15-10-20.
 */

public class HttpClientUtil2 {

    private final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
    private final HttpClient httpClient = new HttpClient(new MultiThreadedHttpConnectionManager());
    private int connTime = 1000;
    private int soTime = 2000;

    private final static String DEFAULT_CHARSET = "UTF-8";
    private final static String DEFAULT_USER_AGENT = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; InfoPath.2)";

    public HttpClientUtil2() {
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(connTime);
        httpClient.getHttpConnectionManager().getParams().setSoTimeout(soTime);
    }

    /**
     * GetMethod -> String
     * @param uri
     * @param charset
     * @return
     */
    public Map<String,Object> getWithCookie(String uri, String charset, String cookie) {
        GetMethod getMethod = null;
        try {
            getMethod = getGetMethodWithCookie(uri, charset, cookie);
        } catch (UnsupportedEncodingException e) {

        }
        boolean setCookie = uri.equals("http://www.qunar.com/twell/cookie/allocateCookie.jsp");
        return getWithGetMethod(charset, getMethod,setCookie);
    }

    /**
     * handle GetMethod -> String
     * @param charset getMethod
     * @param charset
     * @return
     */
    private Map<String,Object> getWithGetMethod(String charset, GetMethod getMethod,boolean setCookie) {
        if (getMethod == null) {
            return null;
        }

        try {
            int status = httpClient.executeMethod(getMethod);
            if (status != 200) {
                return null;
            }
            Map<String,Object> response = Maps.newHashMap();
            byte[] bytes = getMethod.getResponseBody();
            String content = null;
            if(bytes != null){
                content = new String(bytes, charset);
            }
            response.put("content",content);
            if(setCookie){
                Header[] header = getMethod.getResponseHeaders("Set-Cookie");
                if(header != null){
                    response.put("Set-Cookie",header);
                }
            }
            return response;
        } catch (Exception e) {

        } finally {
            if (getMethod != null) {
                getMethod.releaseConnection();
            }
        }
        return null;
    }

    private GetMethod getGetMethodWithCookie(String uri, String charset,
                                             String cookie) throws UnsupportedEncodingException {
        GetMethod getMethod = getGetMethod(uri, charset);
        if (StringUtils.isNotEmpty(cookie)) {
            getMethod.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
            getMethod.setRequestHeader("cookie", cookie);
        }
        return getMethod;
    }

    private GetMethod getGetMethod(String uri, String charset) throws UnsupportedEncodingException {
        if (StringUtils.isEmpty(uri)) {
            uri = "/";
        }

        uri = this.doURLEncode(uri, charset);
        GetMethod getMethod = new GetMethod(uri);
        getMethod.getParams().setContentCharset(charset);
        getMethod.setRequestHeader("Accept-Language", "zh-cn");
        getMethod.setRequestHeader("User-Agent", DEFAULT_USER_AGENT);
        getMethod.setRequestHeader("Connection"," Keep-Alive");
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, soTime);
        return getMethod;
    }


    /**
     * Chinese character encode
     *
     * @param uri
     * @param charset
     * @return
     * @throws java.io.UnsupportedEncodingException
     */
    private String doURLEncode(String uri, String charset) throws UnsupportedEncodingException {
        // Chinese character
        String regEx = "[\\u4e00-\\u9fa5]";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(uri);
        while (matcher.find()) {
            uri = uri.replaceAll(matcher.group(0), URLEncoder.encode(matcher.group(0), charset));
            matcher = pattern.matcher(uri);
        }
        return uri;
    }

    public String postHtml(String url,String param){
        String result = null;
        if(param.length() <= 200){

        }
        try{
            URL postUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded;charset=utf-8");

            connection.connect();
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            String content = param;
            out.writeBytes(content);
            out.flush();
            out.close();
            result = getStringFromResponseStream(connection.getInputStream(),"utf-8");
            connection.disconnect();
        } catch (IOException e) {
            return null;
        }
        return result;
    }

    public String getHtml(String url){
        String result = null;
        try{
            URL postUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded;charset=utf-8");

            connection.connect();
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.flush();
            out.close();
            result = getStringFromResponseStream(connection.getInputStream(),"utf-8");
            connection.disconnect();
        } catch (IOException e) {
            logger.error("getHtml error ,error is", e);
            return null;
        }
        return result;
    }


    private String getStringFromResponseStream(InputStream is,String charSet)
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
