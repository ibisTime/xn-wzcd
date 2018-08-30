package com.cdkj.loan.base;

import java.util.Calendar;
import java.util.Date;

import org.unitils.UnitilsJUnit4;

import com.cdkj.loan.common.DateUtil;

public class TestJUnit extends UnitilsJUnit4 {

    public static void main(String[] args) {
        Date date = DateUtil.strToDate("2018-08-29 20:56:00",
            DateUtil.DATA_TIME_PATTERN_1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        long time1 = cal.getTimeInMillis();
        cal.setTime(new Date());
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        int days = Integer.parseInt(String.valueOf(between_days));
        System.out.println(days);
        // String host = "https://jisucxdq.market.alicloudapi.com";
        // String path = "/car/detail";
        // String method = "GET";
        // String appcode = "1bd9832a74284772a7549ff0cc51043e";
        // Map<String, String> headers = new HashMap<String, String>();
        // // 最后在header中的格式(中间是英文空格)为Authorization:APPCODE
        // // 83359fd73fe94948385f570e3c139105
        // headers.put("Authorization", "APPCODE " + appcode);
        // Map<String, String> querys = new HashMap<String, String>();
        // querys.put("carid", "2571");
        // try {
        // /**
        // * 重要提示如下:
        // * HttpUtils请从
        // *
        // https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
        // * 下载
        // *
        // * 相应的依赖请参照
        // *
        // https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
        // */
        // HttpResponse response = HttpUtils.doGet(host, path, method, headers,
        // querys);
        // HttpEntity entity = response.getEntity();
        // String string = EntityUtils.toString(entity);// 获取response的body
        // System.out.println("1------------->" + string);
        // JSONArray json = (JSONArray) JSONArray
        // .parse(string.substring(34, string.length() - 1));
        // // System.out.println("2------------->" + json);
        // for (Object obj : json) {
        // JSONObject jo = (JSONObject) obj;
        // String id = jo.getString("id");
        // // String name = jo.getString("name");
        // // String initial = jo.getString("initial");
        // // String parentid = jo.getString("parentid");
        // // String logo = jo.getString("logo");
        // // String depth = jo.getString("depth");
        // // System.out.println("id = " + jo);
        // // System.out.println("id = " + id);
        // }
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
    }
}
