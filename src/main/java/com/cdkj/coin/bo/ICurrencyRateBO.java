package com.cdkj.coin.bo;

import com.cdkj.coin.domain.CurrencyRate;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by tianlei on 2017/十一月/13.
 */
public interface ICurrencyRateBO {

    CurrencyRate currencyRateByCurrency(String currency);

    int changeRate(String currency, BigDecimal rate,String origin);

    List<CurrencyRate> allCurrencyRate();

}
