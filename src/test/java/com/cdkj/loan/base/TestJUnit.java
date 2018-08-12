package com.cdkj.loan.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.unitils.UnitilsJUnit4;

import com.alibaba.fastjson.JSONArray;
import com.cdkj.loan.aliyun.util.HttpUtils;

public class TestJUnit extends UnitilsJUnit4 {
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
            HttpResponse response = HttpUtils.doGet(host, path, method, headers,
                querys);
            System.out.println(response.toString());
            // 获取response的body

            JSONArray parseArray = JSONArray
                .parseArray(EntityUtils.toString(response.getEntity()));
            System.out.println("---------->" + parseArray.getJSONArray(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
