package pers.hwj.small.tools.common;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.intellij.codeInspection.blockingCallsDetection.ContextType;
import io.netty.handler.codec.http.HttpContent;
import org.apache.commons.collections.MapUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: huangwenjun16
 * @date: 2023/9/8 09:49
 * @description:
 */
public class HttpUtils {

    public String get(String url, Map<String, String> header, Map<String, String> param) {
        //获得http客户端
        CloseableHttpClient client = HttpClientBuilder.create().build();

        //参数
        StringBuilder params = new StringBuilder();
        if (MapUtils.isNotEmpty(param)) {
            for (Map.Entry<String, String> paramEntry : param.entrySet()) {
                params.append(paramEntry.getKey()).append("=").append(paramEntry.getValue()).append("&");
            }
        }
        //创建get请求
        HttpGet httpGet = new HttpGet(url + "?" + params);
        if (MapUtils.isNotEmpty(header)) {
            for (Map.Entry<String, String> headerEntry : header.entrySet()) {
                httpGet.setHeader(headerEntry.getKey(), headerEntry.getValue());
            }
        }
        //响应模型
        CloseableHttpResponse response = null;
        try {
            //有客户端指定get请求
            response = client.execute(httpGet);
            //从响应模型中获取响应体
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                return EntityUtils.toString(responseEntity);
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //释放资源
                if (client != null) {
                    client.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String post(String url) {
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", ContentType.APPLICATION_JSON.toString());
        return postBody(url, header, null);
    }

    public String postBody(String url, Map<String, String> header, Map<String, Object> body) {
        //获取Http客户端
        CloseableHttpClient client = HttpClientBuilder.create().build();
        //创建Post请求
        HttpPost httpPost = new HttpPost(url);
        if (body == null) {
            body = new HashMap<>();
        }
        StringEntity stringEntity = new StringEntity(new Gson().toJson(body), "utf-8");
        httpPost.setEntity(stringEntity);
        if (MapUtils.isNotEmpty(header)) {
            for (Map.Entry<String, String> headerEntry : header.entrySet()) {
                httpPost.setHeader(headerEntry.getKey(), headerEntry.getValue());
            }
        }
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                return null;
            }
            return EntityUtils.toString(entity, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (client != null) {
                    client.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String postBody(String url, Map<String, Object> body) {
        return postBody(url, null, body);
    }
}
