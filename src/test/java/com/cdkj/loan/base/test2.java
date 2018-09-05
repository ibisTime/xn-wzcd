package com.cdkj.loan.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cdkj.loan.aliyun.util.HttpUtils;

public class test2 {

    public static void main(String[] args) {
        String host = "https://jisucxdq.market.alicloudapi.com";
        String path = "/car/brand";
        String method = "GET";
        String appcode = "1bd9832a74284772a7549ff0cc51043e";
        Map<String, String> headers = new HashMap<String, String>();
        // 最后在header中的格式(中间是英文空格)为Authorization:APPCODE
        // 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();

        try {
            /**
            * 重要提示如下:
            * HttpUtils请从
            * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
            * 下载
            *
            * 相应的依赖请参照
            * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
            */
            HttpResponse response = HttpUtils.doGet(host, path, method,
                headers, querys);
            HttpEntity entity = response.getEntity();
            String string = EntityUtils.toString(entity);
            // int length = string.length();
            // System.out.println(string.substring(34, string.length() - 1));
            // String substring = string.substring(34, length - 1);

            JSONArray json = (JSONArray) JSONArray.parse(string.substring(34,
                string.length() - 1));
            System.out.println(json.toString());

            for (Object obj : json) {
                JSONObject jo = (JSONObject) obj;
                String id = jo.getString("id");
                String name = jo.getString("name");
                String parentid = jo.getString("parentid");
                String logo = jo.getString("logo");
                String price = jo.getString("price");
                System.out.println(id + " " + name + " " + parentid + " "
                        + logo + " " + price + "\n");
            }

            // System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
