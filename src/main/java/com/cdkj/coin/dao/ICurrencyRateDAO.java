package com.cdkj.coin.dao;

import com.cdkj.coin.dao.base.IBaseDAO;
import com.cdkj.coin.domain.CurrencyRate;

/**
 * Created by tianlei on 2017/十一月/13.
 */
public interface ICurrencyRateDAO extends IBaseDAO<CurrencyRate> {

    String NAMESPACE = ICurrencyRateDAO.class.getName().concat(".");

    int update(CurrencyRate currencyRate);
}
