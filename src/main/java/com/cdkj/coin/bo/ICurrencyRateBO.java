package com.cdkj.coin.bo;

import com.cdkj.coin.bo.base.IPaginableBO;
import com.cdkj.coin.domain.CurrencyRate;
import com.cdkj.coin.enums.ECurrency;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by tianlei on 2017/十一月/13.
 */
public interface ICurrencyRateBO extends IPaginableBO<CurrencyRate> {

    CurrencyRate currencyRateByCurrency(String currency);

    int insert(CurrencyRate currencyRate);

    List<CurrencyRate> allCurrencyRate();

//    BigDecimal getAVGRate(ECurrency currency);


}
