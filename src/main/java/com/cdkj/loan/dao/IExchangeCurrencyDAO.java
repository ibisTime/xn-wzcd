package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.ExchangeCurrency;

public interface IExchangeCurrencyDAO extends IBaseDAO<ExchangeCurrency> {
    String NAMESPACE = IExchangeCurrencyDAO.class.getName().concat(".");

    int applyExchange(ExchangeCurrency data);

    int approveExchange(ExchangeCurrency data);

    int doExchange(ExchangeCurrency data);

    int paySuccess(ExchangeCurrency data);

}
