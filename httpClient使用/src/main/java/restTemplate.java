/**
 * @author yang
 * 2021年04月25日 14:21:00
 */
package com.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


public class restTemplate {

    public static void main(String[] args) {
        String url = "http://vsps.corp.qunar.com/shop/directory/select.json?supplierId=3650805796&appcode=vs_vacation_api";
        postWithTimeout(url,null,100,200);
    }

    public static String postWithTimeout(String url, String body, int connectTimeout, int readTiemout) {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(connectTimeout);// 设置建立连接超时时间
        requestFactory.setReadTimeout(readTiemout);// 设置等待返回超时时间
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        HttpHeaders headers = new HttpHeaders();
        //MediaType type = MediaType.parseMediaType(mediaType);
        //headers.setContentType(type);
        headers.add("Accept", "text/html,application/xhtml+xml,application/json;q=0.9,*/*;q=0.8");
        headers.add("Content-Length", "0");
        HttpEntity<String> formEntity = new HttpEntity<String>(body, headers);
        String temp = restTemplate.postForObject(url, formEntity, String.class);
        return temp;
    }
}


