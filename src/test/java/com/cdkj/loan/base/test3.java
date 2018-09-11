package com.cdkj.loan.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cdkj.loan.aliyun.util.HttpUtils;

public class test3 {

    public static void main(String[] args) {

        JSONArray json = null;
        String host = "https://jisucxdq.market.alicloudapi.com";
        String path = "/car/carlist";
        String method = "GET";
        String appcode = "1bd9832a74284772a7549ff0cc51043e";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();

        querys.put("parentid", "2420");
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method,
                headers, querys);
            HttpEntity entity = response.getEntity();
            String string = EntityUtils.toString(entity);// 获取response的body
            // System.out.println(string);
            int length = string.length();
            System.out.println(length);
            String substring = string.substring(34, length - 1);
            // System.out.println(substring);
            json = JSONArray.parseArray(substring);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(json);
        if (null != json) {
            for (int i = 0; i < json.size(); i++) {
                JSONObject jsonObject = json.getJSONObject(i);
                JSONArray ja = jsonObject.getJSONArray("carlist");
                if (null != ja) {
                    for (int j = 0; j < ja.size(); j++) {
                        JSONObject jo = ja.getJSONObject(j);
                        if (null != jo) {
                            String name = jo.getString("name");
                            System.out.println(name);
                        }
                    }
                }
            }
        }

    }

}
