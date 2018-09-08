package com.cdkj.loan.base;

import java.math.BigDecimal;

import org.unitils.UnitilsJUnit4;

import com.cdkj.loan.common.AmountUtil;
import com.cdkj.loan.core.StringValidater;

public class TestJUnit extends UnitilsJUnit4 {

    public static void main(String[] args) {
        String loanAmount = "800000";
        String loanPeriods = "12";
        String bankRate = "0.0";
        Double annualPrincipal = AmountUtil.div(
            StringValidater.toLong(loanAmount),
            StringValidater.toInteger(loanPeriods));// 每期本金
        annualPrincipal = Math.floor(annualPrincipal);// 向下取整
        Double initialPrincipal = StringValidater.toDouble(loanAmount)
                - AmountUtil.mulAB(annualPrincipal,
                    (StringValidater.toDouble(loanPeriods) - 1));// 首期本金
        initialPrincipal = new BigDecimal(initialPrincipal)
            .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();// 保留两位

        // 手续费=贷款额*利率
        Long poundage = AmountUtil.mul(StringValidater.toLong(loanAmount),
            StringValidater.toDouble(bankRate));// 手续费

        // 月供：
        // 首期=1+手续费
        Double initialAmount = initialPrincipal + poundage;
        Double d1 = new BigDecimal(initialAmount)
            .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        // 每期=2
        Double annualAmount = annualPrincipal;
        Double d2 = new BigDecimal(annualAmount)
            .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("d1----" + d1);
        System.out.println("d2----" + d2);
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
