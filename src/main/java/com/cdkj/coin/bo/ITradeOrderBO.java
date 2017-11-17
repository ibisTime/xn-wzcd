package com.cdkj.coin.bo;

import java.math.BigDecimal;
import java.util.List;

import com.cdkj.coin.bo.base.IPaginableBO;
import com.cdkj.coin.domain.Ads;
import com.cdkj.coin.domain.TradeOrder;

public interface ITradeOrderBO extends IPaginableBO<TradeOrder> {

    public String buySubmit(Ads adsSell, String buyUser, BigDecimal tradePrice,
            BigDecimal count, BigDecimal tradeAmount, BigDecimal fee);

    public List<TradeOrder> queryTradeOrderList(TradeOrder condition);

    public TradeOrder getTradeOrder(String code);

    public int cancel(TradeOrder tradeOrder, String updater, String remark);

    public int markPay(TradeOrder tradeOrder, String updater, String remark);

    public int release(TradeOrder tradeOrder, String updater, String remark);

    public int doBsComment(TradeOrder tradeOrder, String userId,
            String comment, String status, String remark);

    public int doSbComment(TradeOrder tradeOrder, String userId,
            String comment, String status, String remark);

    public int applyArbitrate(TradeOrder tradeOrder, String applyUser);

    public int revokePay(TradeOrder tradeOrder, String updater, String string);

    public boolean isExistOningOrder(String adsCode);

}
