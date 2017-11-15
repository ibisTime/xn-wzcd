package com.cdkj.coin.ao;

import java.math.BigDecimal;
import java.util.List;

import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.domain.TradeOrder;

public interface ITradeOrderAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 我要购买
    public String buy(String adsCode, String buyUser, BigDecimal tradePrice,
            BigDecimal count, BigDecimal tradeAmount);

    // 我要出售
    public String sell(String adsCode, String sellUser, BigDecimal tradePrice,
            BigDecimal count, BigDecimal tradeAmount);

    // 取消交易订单
    public void cancel(String code, String updater, String remark);

    // 买家标记打款
    public void markPay(String code, String updater, String remark);

    // 卖家释放
    public void release(String code, String updater, String remark);

    // 评论
    public void comment(String code, String userId, String comment);

    // 申请仲裁
    public void applyArbitrate(String code, String applyUser, String reason,
            String attach);

    public Paginable<TradeOrder> queryTradeOrderPage(int start, int limit,
            TradeOrder condition);

    public List<TradeOrder> queryTradeOrderList(TradeOrder condition);

    public TradeOrder getTradeOrder(String code);

}
