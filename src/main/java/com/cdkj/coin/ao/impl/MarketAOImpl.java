package com.cdkj.coin.ao.impl;

import com.alibaba.fastjson.JSON;
import com.cdkj.coin.ao.IMarketAO;
import com.cdkj.coin.bo.ICurrencyRateBO;
import com.cdkj.coin.bo.IMarketBO;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.dao.IMarketDAO;
import com.cdkj.coin.domain.CurrencyRate;
import com.cdkj.coin.domain.Market;
import com.cdkj.coin.enums.ECoin;
import com.cdkj.coin.enums.ECurrency;
import com.cdkj.coin.enums.EMarketOrigin;
import com.sun.javafx.tools.packager.MakeAllParams;
import jdk.Exported;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tianlei on 2017/十一月/13.
 */
@Service
public class MarketAOImpl implements IMarketAO {

    @Autowired
    IMarketBO marketBO;

    @Autowired
    ICurrencyRateBO currencyRateBO;

    @Override
    public Market marketByCoinType(String coinType) {

      return  this.marketBO.marketByCoinTypeAndOrigin(coinType,EMarketOrigin.BITFINEX.getCode());

    }

    public void obtainMarket() {

        // 获取usd 的行情
        String requestStr = "https://api.bitfinex.com/v1/pubticker/ethusd";
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder().get().url(requestStr).build();
        Call call = okHttpClient.newCall(request);
        try {

            Response response = call.execute();
            String jsonStr = response.body().string();

            Map map = (Map) JSON.parseObject(jsonStr, HashMap.class);

            Market market = new Market();
            market.setReferCurrency(ECurrency.CNY.getCode());
            market.setCoin(ECoin.ETH.getCode());
            market.setUpdateDatetime(new Date());
            market.setLastPrice(this.convertPriceToRMB((String)map.get("last_price")));
            market.setVolume((String)map.get("volume"));

            market.setMid(this.convertPriceToRMB((String)map.get("mid")));
            market.setAsk(this.convertPriceToRMB((String)map.get("ask")));
            market.setBid(this.convertPriceToRMB((String)map.get("bid")));

            market.setLow(this.convertPriceToRMB((String)map.get("low")));
            market.setHigh(this.convertPriceToRMB((String)map.get("high")));

            //保存
            this.marketBO.updateMarket(EMarketOrigin.BITFINEX.getCode(),ECoin.ETH.getCode(),market);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private BigDecimal convertPriceToRMB(String value) {

        // 获取美元的汇率
        CurrencyRate usdCurrencyRate = this.currencyRateBO.currencyRateByCurrency(ECurrency.USD.getCode());
        // 转换为人民币
        BigDecimal rmbValue = new BigDecimal(value).multiply(usdCurrencyRate.getRate());
        rmbValue.setScale(4,BigDecimal.ROUND_HALF_UP);
        return rmbValue;
    }

}
