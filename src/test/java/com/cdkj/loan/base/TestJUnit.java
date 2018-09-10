package com.cdkj.loan.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.unitils.UnitilsJUnit4;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cdkj.loan.aliyun.util.HttpUtils;

public class TestJUnit extends UnitilsJUnit4 {

    public static void main(String[] args) {
        ArrayList<JSONArray> list = new ArrayList<JSONArray>();
        JSONArray json = null;
        String host = "https://jisucxdq.market.alicloudapi.com";
        String path = "/car/detail";
        String method = "GET";
        String appcode = "1bd9832a74284772a7549ff0cc51043e";
        Map<String, String> headers = new HashMap<String, String>();
        // 最后在header中的格式(中间是英文空格)为Authorization:APPCODE
        // 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("carid", "228");
        try {
            /**
            * 重要提示如下:
            * HttpUtils请从
            *
            https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
            * 下载
            *
            * 相应的依赖请参照
            *
            https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
            */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers,
                querys);
            HttpEntity entity = response.getEntity();
            String string = EntityUtils.toString(entity);// 获取response的body
            String substring = string.substring(34, string.length() - 1);
            json = JSONArray.parseArray(substring);
            list.add(json);
            for (Object obj : json) {
                JSONObject jo = (JSONObject) obj;
                String id = jo.getString("id");
                // String name = jo.getString("name");
                // String initial = jo.getString("initial");
                // String parentid = jo.getString("parentid");
                // String logo = jo.getString("logo");
                // String depth = jo.getString("depth");
                // System.out.println("id = " + jo);
                // System.out.println("id = " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(list);
    }
}
