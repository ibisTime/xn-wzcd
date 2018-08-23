package com.cdkj.loan.base;

import java.math.BigDecimal;

import org.unitils.UnitilsJUnit4;

import com.cdkj.loan.common.AmountUtil;
import com.cdkj.loan.core.StringValidater;

public class TestJUnit extends UnitilsJUnit4 {

    public static void main(String[] args) {

        String loanAmount = "2000000000";
        String loanPeriods = "12";
        String bankRate = "0.1";
        Double annualPrincipal = AmountUtil.div(
            StringValidater.toDouble(loanAmount),
            StringValidater.toLong(loanPeriods));// 每期本金
        Double initialPrincipal = (StringValidater.toDouble(loanAmount)
                - AmountUtil.mulAB(annualPrincipal,
                    (StringValidater.toDouble(loanPeriods) - 1)));// 首期本金

        // System.out.println(StringValidater.toDouble(loanAmount));
        // System.out.println(StringValidater.toDouble(loanPeriods));

        // 手续费=贷款额*基准利率
        // 3.首期=手续费-（4）*（期数-1）
        // 4.每期=(2)*基准利率
        double rate = 0.0;// 基准利率
        Long poundage = AmountUtil.mul(StringValidater.toLong(loanAmount),
            rate);// 手续费
        Double annualPoundage = AmountUtil.mulAB(annualPrincipal, rate);// 每期手续费
        Double initialPoundage = poundage - AmountUtil.mulAB(annualPoundage,
            (StringValidater.toDouble(loanPeriods) - 1));// 首期手续费

        // 高息金额=贷款额*（总利率-基准利率）
        // 5.高息金额首期=高息金额-（6）*（期数-1）
        // 6.高息金额每期=高息金额/期数
        // HighRate
        Long highRate = AmountUtil.mul(StringValidater.toLong(loanAmount),
            (StringValidater.toDouble(bankRate) - rate));// 高息金额
        Double annualHighRate = AmountUtil.div(highRate,
            StringValidater.toInteger(loanPeriods));// 高息金额每期
        Double initialHighRate = highRate - AmountUtil.mulAB(annualHighRate,
            (StringValidater.toDouble(loanPeriods) - 1));// 高息金额首期

        // 高息手续费=高息金额*基准利率
        // 7.高息手续费首期=（8）*（期数-1）
        // 8.高息手续费每期=(6）*基准利率
        Long highRatePoundage = AmountUtil.mul(highRate, rate);// 高息手续费
        Double annualHighRatePoundage = AmountUtil.mulAB(annualHighRate, rate);// 高息手续费每期
        Double initialHighRatePoundage = AmountUtil.mulAB(
            annualHighRatePoundage,
            (StringValidater.toDouble(loanPeriods) - 1));// 高息手续费首期

        // 首期月供=1+3+5+7
        Double initialAmount = initialPrincipal + initialPoundage
                + initialHighRate + initialHighRatePoundage;
        Double d1 = new BigDecimal(initialAmount)
            .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        // 每期月供=2+4+6+8
        Double annualAmount = annualPrincipal + annualPoundage + annualHighRate
                + annualHighRatePoundage;
        Double d2 = new BigDecimal(annualAmount)
            .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        long longValue = new Double(d1).longValue();
        System.out.println(String.valueOf(new Double(d1).longValue()));

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
