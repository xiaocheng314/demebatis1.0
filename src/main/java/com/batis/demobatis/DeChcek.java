package com.batis.demobatis;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

//
import com.alibaba.fastjson.JSONObject;
//
public class DeChcek {

    public static void main(String[] args) throws IOException {
//                String appid = "wxc4b61434af5db091";
//        String secret = "15d9f3b2fd692e874681edabc2658c11";
//        String js_code = "043TuyMk0xcsUp12lzKk0PjyMk0TuyMC";
//        String grant_type = "authorization_code";
//        String url = "https://api.weixin.qq.com/sns/jscode2session?" + "appid=" + appid + "&secret=" + secret + "&js_code=" + js_code + "&grant_type=" + grant_type;
//        System.out.println(url);
//        String jsonObject = HttpClientUtil.get(HttpConfig.custom().url(url));
//        JSONObject object = JSONObject.parseObject(jsonObject);
//        String key = (String) object.get("session_key");
//        System.out.println(key);
//        System.out.println(jsonObject);
//
////        ################
//      HttpGet httpGet = new HttpGet("https://api.weixin.qq.com/sns/jscode2session?appid=wxc4b61434af5db091&secret=15d9f3b2fd692e874681edabc2658c11&js_code=0939CH0w3quvRU2Kh62w37fDaC49CH0A&grant_type=authorization_code");
        HttpGet httpGet = new HttpGet("https://blog.csdn.net/gulang03/article/details/81175854");
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = client.execute(httpGet);
        HttpEntity httpEntity=response.getEntity();
        String result = EntityUtils.toString(httpEntity);
        System.out.println(result);
    }
}
