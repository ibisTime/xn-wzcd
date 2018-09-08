package com.cdkj.loan.base;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.unitils.UnitilsJUnit4;

import com.cdkj.loan.common.DateUtil;

public class TestJUnit extends UnitilsJUnit4 {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        Date date = DateUtil.strToDate("2018-02-03",
            DateUtil.FRONT_DATE_FORMAT_STRING);
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +1);
        Date time = calendar.getTime();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(time));
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
