package com.cdkj.coin.ao;

import java.util.List;

import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.domain.TradeOrder;

public interface ITradeOrderAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public Paginable<TradeOrder> queryTradeOrderPage(int start, int limit,
            TradeOrder condition);

    public List<TradeOrder> queryTradeOrderList(TradeOrder condition);

    public TradeOrder getTradeOrder(String code);

}
