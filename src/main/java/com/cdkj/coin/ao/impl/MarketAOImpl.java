package com.cdkj.coin.ao.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cdkj.coin.ao.IMarketAO;
import com.cdkj.coin.bo.ICurrencyRateBO;
import com.cdkj.coin.bo.IMarketBO;
import com.cdkj.coin.bo.ISYSConfigBO;
import com.cdkj.coin.common.SysConstants;
import com.cdkj.coin.domain.CurrencyRate;
import com.cdkj.coin.domain.Market;
import com.cdkj.coin.domain.MarketDetail;
import com.cdkj.coin.dto.req.XN625291Req;
import com.cdkj.coin.enums.ECoin;
import com.cdkj.coin.enums.ECurrency;
import com.cdkj.coin.enums.EMarketOrigin;
import com.cdkj.coin.exception.BizException;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by tianlei on 2017/十一月/13.
 */
@Service
public class MarketAOImpl implements IMarketAO {

    private static final Logger logger = LoggerFactory
            .getLogger(MarketAOImpl.class);
    private static List<MarketDetail> marketDetailList;

    @Autowired
    IMarketBO marketBO;

    @Autowired
    ICurrencyRateBO currencyRateBO;

    @Autowired
    ISYSConfigBO sysConfigBO;

    @Override
    public List<Market> marketByCoin(List<String> coinList) {

        Market condition = new Market();
        if (coinList != null && !coinList.isEmpty()) {
            condition.setCoinList(coinList);
        }
        condition.setOrigin(EMarketOrigin.BITFINEX.getCode());
        return this.marketBO.marketListByCondation(condition);

        // return this.marketBO.marketByCoinTypeAndOrigin(coinType,
        // EMarketOrigin.BITFINEX.getCode());

    }

    @Override
    public List<Market> marketListByReq(XN625291Req req) {

        Market condition = new Market();
        condition.setCoin(req.getCoin());
        return this.marketBO.marketListByCondation(condition);

    }

    @Override
    public Market coinPriceByPlatform(String coin) {

        ECoin eCoin = null;
        if (coin.equals(ECoin.ETH.getCode())) {
            eCoin = ECoin.ETH;
        }

        if (eCoin == null) {
            throw new BizException("xn000", coin + "不支持的货币类型");
        }

        Market market = this.marketBO.standardMarket(eCoin);

        //获取平台调控值
        BigDecimal x = this.sysConfigBO.getBigDecimalValue(SysConstants.ETH_COIN_PRICE_X);

        //计算平台调控过的值
        market.setMid(market.getMid().add(x));

        //
        return this.marketBO.standardMarket(eCoin);

    }

    @Override
    public List<MarketDetail> marketDetailList() {

        if (marketDetailList != null) {

            return marketDetailList;

        } else {

            this.obtainMarketDetailList();
            return marketDetailList;
        }

    }

    // 获取多个币种的行情列表
    @Scheduled(cron = "*/30 * * * * ?")
    public void obtainMarketDetailList() {

        //去拉取行情列表
        String requestStr = "https://api.coinmarketcap.com/v1/ticker/?limit=25";
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder().get().url(requestStr).build();
        Call call = okHttpClient.newCall(request);
        try {

            Response response = call.execute();
            String jsonStr = response.body().string();

            //先转化为map
            List<Map> marketDetailMapList = JSONArray.parseArray(jsonStr, Map.class);

            //
            List<MarketDetail> marketDetailList = JSONArray.parseArray(jsonStr, MarketDetail.class);

            if (marketDetailMapList != null) {

                BigDecimal currencyRate = this.currencyRateBO.currencyRateByCurrency(ECurrency.USD.getCode()).getRate();
                for (int i = 0; i < marketDetailList.size(); i++) {

                    MarketDetail marketDetail = marketDetailList.get(i);
                    Map marketDetailMap = marketDetailMapList.get(i);

                    BigDecimal priceCNY = new BigDecimal(marketDetail.getPrice_usd()).multiply(currencyRate);
                    String priceCNYString = priceCNY.setScale(2, RoundingMode.HALF_EVEN).toString();
                    marketDetail.setPrice_cny(priceCNYString);

                    marketDetail.setOne_day_volume_usd((String) marketDetailMap.get("24h_volume_usd"));

                    // 获取人民币转化
                    BigDecimal one_day_volume_cny = new BigDecimal(marketDetail.getOne_day_volume_usd()).multiply(currencyRate);
                    String one_day_volume_cny_String = one_day_volume_cny.setScale(2, RoundingMode.HALF_EVEN).toString();
                    marketDetail.setOne_day_volume_cny(one_day_volume_cny_String);
                }


                MarketAOImpl.marketDetailList = marketDetailList;

            } else {

                logger.error(requestStr + "行情详情数据拉取异常" + Thread.currentThread().getStackTrace()[1].getMethodName());

            }


        } catch (Exception e) {

            logger.error("行情详情数据拉取异常，原因：" + e.getMessage() + Thread.currentThread().getStackTrace()[1].getMethodName());

        }

    }

    public void obtainMarket() {

        // 1.从bitfinex 获取行情
        this.obtainBitfinexMarket();

        // 2.从okex 获取行情
        this.obtainOkexMarket();

    }

    private void obtainOkexMarket() {

        this.obtainOkexMarketByUrlAndCoin(
                "https://www.okex.com/api/v1/ticker.do?symbol=eth_usdt",
                ECoin.ETH.getCode());

        this.obtainOkexMarketByUrlAndCoin(
                "https://www.okex.com/api/v1/ticker.do?symbol=btc_usdt",
                ECoin.BTC.getCode());

        // 获取usd 的行情
        // {
        // date: "1510573295",
        // ticker: {
        // high: "319.00",
        // vol: "9799.39",
        // last: "313.71",
        // low: "285.00",
        // buy: "313.71",
        // sell: "313.75"
        // }
        // }
    }

    private void obtainBitfinexMarket() {
        //
        this.obtainBitfinexMarketByUrlAndCoin(
                "https://api.bitfinex.com/v1/pubticker/ethusd", ECoin.ETH.getCode());

        //
        this.obtainBitfinexMarketByUrlAndCoin(
                "https://api.bitfinex.com/v1/pubticker/btcusd", ECoin.BTC.getCode());

    }

    private void obtainBitfinexMarketByUrlAndCoin(String url, String coin) {

        String requestStr = url;
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();
        ;

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
            market.setLastPrice(this.convertPriceToRMB((String) map
                    .get("last_price")));
            market.setVolume((String) map.get("volume"));

            market.setMid(this.convertPriceToRMB((String) map.get("mid")));
            market.setAsk(this.convertPriceToRMB((String) map.get("ask")));
            market.setBid(this.convertPriceToRMB((String) map.get("bid")));

            market.setLow(this.convertPriceToRMB((String) map.get("low")));
            market.setHigh(this.convertPriceToRMB((String) map.get("high")));

            // 保存
            this.marketBO.updateMarket(EMarketOrigin.BITFINEX.getCode(), coin,
                    market);

        } catch (Exception e) {
            logger.error("行情数据拉取异常，原因：" + e.getMessage() + "-" + Thread.currentThread().getStackTrace()[1].getMethodName());
        }

    }

    private void obtainOkexMarketByUrlAndCoin(String url, String coin) {

        String requestStr = url;
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder().get().url(requestStr).build();
        Call call = okHttpClient.newCall(request);
        try {

            Response response = call.execute();
            String jsonStr = response.body().string();

            Map map = (Map) JSON.parseObject(jsonStr, HashMap.class);
            Map tickerMap = (Map) map.get("ticker");

            Market market = new Market();
            market.setReferCurrency(ECurrency.CNY.getCode());
            market.setCoin(ECoin.ETH.getCode());
            market.setUpdateDatetime(new Date());
            market.setLastPrice(this.convertPriceToRMB((String) tickerMap
                    .get("last")));
            market.setVolume((String) tickerMap.get("vol"));

            BigDecimal bid = this.convertPriceToRMB((String) tickerMap
                    .get("buy"));
            BigDecimal ask = this.convertPriceToRMB((String) tickerMap
                    .get("sell"));
            market.setAsk(ask);
            market.setBid(bid);
            market.setMid(bid.add(ask).divide(new BigDecimal(2)));
            market
                    .setLow(this.convertPriceToRMB((String) tickerMap.get("low")));
            market.setHigh(this.convertPriceToRMB((String) tickerMap
                    .get("high")));

            // 确定mid
            // 保存
            this.marketBO.updateMarket(EMarketOrigin.OKEX.getCode(), coin,
                    market);

        } catch (Exception e) {
            logger.error("行情数据拉取异常，原因：" + e.getMessage());
        }

    }

    // private void 美元字符串转换为，人民币
    private BigDecimal convertPriceToRMB(String value) {

        // 获取美元的汇率
        CurrencyRate usdCurrencyRate = this.currencyRateBO
                .currencyRateByCurrency(ECurrency.USD.getCode());
        // 转换为人民币
        BigDecimal rmbValue = new BigDecimal(value).multiply(usdCurrencyRate
                .getRate());
        rmbValue.setScale(4, BigDecimal.ROUND_HALF_UP);
        return rmbValue;

    }

}
