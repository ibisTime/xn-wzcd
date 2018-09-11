package com.cdkj.loan.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.unitils.UnitilsJUnit4;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cdkj.loan.aliyun.util.HttpUtils;
import com.cdkj.loan.bo.IBrandBO;

public class TestJUnit extends UnitilsJUnit4 {

    @Autowired
    static IBrandBO brandBO;

    public static void main(String[] args) {
        ArrayList<JSONArray> list = new ArrayList<JSONArray>();
        JSONArray json = null;
        String host = "https://jisucxdq.market.alicloudapi.com";
        String path = "/car/carlist";
        String method = "GET";
        String appcode = "1bd9832a74284772a7549ff0cc51043e";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("parentid", "1");
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers,
                querys);
            HttpEntity entity = response.getEntity();
            String string = EntityUtils.toString(entity);// 获取response的body
            String substring = string.substring(34, string.length() - 1);
            json = JSONArray.parseArray(substring);
            System.out.println("json----------->" + json + "|||||");
            list.add(json);
            for (Object obj : json) {
                JSONObject jo = (JSONObject) obj;
                String carlist = jo.getString("carlist");
                System.out.println("carlist = " + carlist);
                JSONArray json2 = JSONArray.parseArray(carlist);
                for (Object object : json2) {
                    JSONObject jo2 = (JSONObject) object;
                    String fullname = jo2.getString("fullname");
                    System.out.println("fullname = " + fullname);
                    String list1 = jo2.getString("list");
                    JSONArray json3 = JSONArray.parseArray(list1);
                    for (Object object2 : json3) {
                        JSONObject jo3 = (JSONObject) object2;
                        String id = jo3.getString("id");
                        String name = jo3.getString("name");
                        String logo = jo3.getString("logo");
                        String price = jo3.getString("price");
                        String parentid = jo3.getString("parentid");
                        jo3.getString("");
                    }
                }
                // String parentid = jo.getString("parentid");
                // String logo = jo.getString("logo");
                // String depth = jo.getString("depth");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // System.out.println(list);
    }
}
