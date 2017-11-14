package com.cdkj.coin.bo;

import java.util.List;

import com.cdkj.coin.bo.base.IPaginableBO;
import com.cdkj.coin.domain.TradeOrder;

public interface ITradeOrderBO extends IPaginableBO<TradeOrder> {

    public String saveTradeOrder(TradeOrder data);

    public List<TradeOrder> queryTradeOrderList(TradeOrder condition);

    public TradeOrder getTradeOrder(String code);

}
