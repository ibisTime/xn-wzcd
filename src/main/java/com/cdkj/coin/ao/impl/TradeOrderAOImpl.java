package com.cdkj.coin.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.coin.ao.ITradeOrderAO;
import com.cdkj.coin.bo.ITradeOrderBO;
import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.domain.TradeOrder;

@Service
public class TradeOrderAOImpl implements ITradeOrderAO {

    @Autowired
    private ITradeOrderBO tradeOrderBO;

    @Override
    public Paginable<TradeOrder> queryTradeOrderPage(int start, int limit,
            TradeOrder condition) {
        return tradeOrderBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<TradeOrder> queryTradeOrderList(TradeOrder condition) {
        return tradeOrderBO.queryTradeOrderList(condition);
    }

    @Override
    public TradeOrder getTradeOrder(String code) {
        return tradeOrderBO.getTradeOrder(code);
    }
}
