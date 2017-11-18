package com.cdkj.coin.ao.impl;

import com.alibaba.fastjson.JSON;
import com.cdkj.coin.ao.ICurrencyRateAO;
import com.cdkj.coin.bo.ICurrencyRateBO;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.domain.CurrencyRate;
import com.cdkj.coin.enums.ECurrency;
import com.cdkj.coin.http.JsonUtils;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.RequestBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tianlei on 2017/十一月/13.
 */
@Service
public class CurrencyRateAOImpl implements ICurrencyRateAO {

    @Autowired
    ICurrencyRateBO currencyRateBO;

    @Override
    public CurrencyRate currencyRateByCurrency(String currency) {

        return this.currencyRateBO.currencyRateByCurrency(currency);

    }

    @Override
    public List<CurrencyRate> allCurrencyRate() {

        return this.currencyRateBO.allCurrencyRate();
    }

    public void obtainCurrencyRate() {


        String requestStr = "http://web.juhe.cn:8080/finance/exchange/rmbquot?key=04448ab31ce7199b12b7ce8dfe9a5dd3";

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder().get().url(requestStr).build();
        Call call = okHttpClient.newCall(request);
        try {

            Response response = call.execute();
            String jsonStr = response.body().string();
            Map map = (Map) JSON.parseObject(jsonStr, HashMap.class);

            if (!map.get("resultcode").equals("200")) {
                return;
            }

            List resultList = (List) map.get("result");
            Map dataMap = (Map) resultList.get(0);

//            {
//                "bankConversionPri":"773.3300",
//                    "date":"2017-11-13",
//                    "fBuyPri":"771.7200",
//                    "fSellPri":"777.1400",
//                    "mBuyPri":"747.6800",
//                    "mSellPri":"777.1400",
//                    "name":"欧元",
//                    "time":"14:45:05"
//            }
            BigDecimal usdDecimal = this.calculateRate((Map) dataMap.get("data1"));
            BigDecimal hkdDecimal = this.calculateRate((Map) dataMap.get("data3"));
            if (usdDecimal == null || hkdDecimal == null) {
                return;
            }

            //改为刷新数据库
            //跟新数据库
            this.currencyRateBO.changeRate(ECurrency.USD.getCode(), usdDecimal, "juhe");
            this.currencyRateBO.changeRate(ECurrency.HKD.getCode(), hkdDecimal, "juhe");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private BigDecimal calculateRate(Map rateMap) {

        //100美元兑 100 人民币
        String rate100Str = (String) rateMap.get("bankConversionPri");
        if (StringUtils.isBlank(rate100Str)) {
            return null;
        }
        return new BigDecimal(rate100Str).divide(new BigDecimal("100"));

    }
}
