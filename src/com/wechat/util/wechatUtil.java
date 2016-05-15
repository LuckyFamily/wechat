package com.wechat.util;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by jiangyiming on 5/14/16.
 */
public class wechatUtil {
    private static final String APPID="wxbb3f930754feb0a9";
    private static final String APPSECRET="3236e78bf4a4b01d35463f44c7e74b9a";

    /**
     * get请求
     * @param url
     * @return
     */
    public static JSONObject doGetStr(String url){
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        JSONObject jsonObject = null;
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            if (entity!=null){
                String result = EntityUtils.toString(entity,"UTF-8");
                jsonObject = JSONObject.fromObject(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }


    /**
     * post请求
     * @param url
     * @param outStr
     * @return
     */
    public static JSONObject doPostStr(String url,String outStr){
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        JSONObject jsonObject = null;
        try {
            httpPost.setEntity(new StringEntity(outStr,"UTF-8"));
            HttpResponse response = client.execute(httpPost);
            String result = EntityUtils.toString(response.getEntity(),"UTF-8");
            jsonObject = JSONObject.fromObject(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
