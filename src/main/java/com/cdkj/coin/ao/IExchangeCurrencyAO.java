package com.cdkj.coin.ao;

import java.math.BigDecimal;

import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.domain.ExchangeCurrency;

public interface IExchangeCurrencyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 获取虚拟币价值。1fromCurrency等于多少toCurrency
    public Double getExchangeRate(String fromCurrency, String toCurrency);

    public String applyExchange(String userId, BigDecimal fromAmount,
            String fromCurrency, String toCurrency);

    public void approveExchange(String code, String approveResult,
            String approver, String approveNote);

    public Paginable<ExchangeCurrency> queryExchangeCurrencyPage(int start,
            int limit, ExchangeCurrency condition);

    public ExchangeCurrency getExchangeCurrency(String code);

    // 不同用户间同币种或不同币种划转资金
    public void doTransfer(String fromUserId, String fromCurrency,
            String toUserId, String toCurrency, BigDecimal amount);

}
