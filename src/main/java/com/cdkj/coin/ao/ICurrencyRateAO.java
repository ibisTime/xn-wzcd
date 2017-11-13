package com.cdkj.coin.ao;

import com.cdkj.coin.domain.CurrencyRate;

import java.util.List;

/**
 * Created by tianlei on 2017/十一月/13.
 */
public interface ICurrencyRateAO {

    CurrencyRate currencyRateByCurrency(String currency);
    List<CurrencyRate> allCurrencyRate();

}
