package com.cdkj.coin.bo.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.coin.bo.ITradeOrderBO;
import com.cdkj.coin.bo.base.PaginableBOImpl;
import com.cdkj.coin.common.DateUtil;
import com.cdkj.coin.core.OrderNoGenerater;
import com.cdkj.coin.dao.ITradeOrderDAO;
import com.cdkj.coin.domain.Ads;
import com.cdkj.coin.domain.TradeOrder;
import com.cdkj.coin.enums.EGeneratePrefix;
import com.cdkj.coin.enums.ETradeOrderStatus;
import com.cdkj.coin.enums.ETradeOrderType;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.EBizErrorCode;

@Component
public class TradeOrderBOImpl extends PaginableBOImpl<TradeOrder> implements
        ITradeOrderBO {

    @Autowired
    private ITradeOrderDAO tradeOrderDAO;

    @Override
    public String buySubmit(Ads ads, String buyUser, BigDecimal tradePrice,
            BigDecimal count, BigDecimal tradeAmount, BigDecimal fee) {

        TradeOrder data = new TradeOrder();

        String code = OrderNoGenerater.generate(EGeneratePrefix.TRADE_ORDER
            .getCode());
        Date now = new Date();

        data.setCode(code);
        data.setType(ETradeOrderType.BUY.getCode());
        data.setAdsCode(ads.getCode());
        data.setBuyUser(buyUser);
        data.setSellUser(ads.getUserId());

        data.setLeaveMessage(ads.getLeaveMessage());
        data.setTradeCurrency(ads.getTradeCurrency());
        data.setTradeCoin(ads.getTradeCoin());
        data.setTradePrice(tradePrice);
        data.setTradeAmount(tradeAmount);

        data.setFee(fee);
        data.setCount(count);
        data.setPayType(ads.getPayType());
        data.setInvalidDatetime(DateUtil.getRelativeDateOfMinute(now,
            ads.getPayLimit()));
        data.setStatus(ETradeOrderStatus.TO_PAY.getCode());

        data.setCreateDatetime(now);
        data.setUpdater(buyUser);
        data.setUpdateDatatime(now);
        data.setRemark("新订单，等待支付");

        tradeOrderDAO.insert(data);

        return code;
    }

    @Override
    public String sellSubmit(Ads ads, String sellUser, BigDecimal tradePrice,
                             BigDecimal count, BigDecimal tradeAmount, BigDecimal fee) {

        TradeOrder data = new TradeOrder();
        String code = OrderNoGenerater.generate(EGeneratePrefix.TRADE_ORDER
                .getCode());
        Date now = new Date();
        data.setCode(code);
        data.setType(ETradeOrderType.SELL.getCode());
        data.setAdsCode(ads.getCode());
        data.setBuyUser(ads.getUserId());
        data.setSellUser(sellUser);

        data.setLeaveMessage(ads.getLeaveMessage());
        data.setTradeCurrency(ads.getTradeCurrency());
        data.setTradeCoin(ads.getTradeCoin());
        data.setTradePrice(tradePrice);
        data.setTradeAmount(tradeAmount);

        data.setFee(fee);
        data.setCount(count);
        data.setPayType(ads.getPayType());
        data.setInvalidDatetime(DateUtil.getRelativeDateOfMinute(now,
                ads.getPayLimit()));
        data.setStatus(ETradeOrderStatus.TO_PAY.getCode());

        data.setCreateDatetime(now);
        data.setUpdater(sellUser);
        data.setUpdateDatatime(now);
        data.setRemark("新订单，等待支付");
        tradeOrderDAO.insert(data);

        return code;
    }

    @Override
    public int cancel(TradeOrder tradeOrder, String updater, String remark) {
        int count = 0;
        if (tradeOrder != null) {
            tradeOrder.setStatus(ETradeOrderStatus.CANCEL.getCode());
            tradeOrder.setUpdater(updater);
            tradeOrder.setUpdateDatatime(new Date());
            tradeOrder.setRemark(StringUtils.isNotBlank(remark) ? remark
                    : "订单已被取消");
            count = tradeOrderDAO.updateCancel(tradeOrder);
        }
        return count;
    }

    @Override
    public int markPay(TradeOrder tradeOrder, String updater, String remark) {
        int count = 0;
        if (tradeOrder != null) {
            Date now = new Date();
            tradeOrder.setStatus(ETradeOrderStatus.PAYED.getCode());
            tradeOrder.setMarkDatetime(now);
            tradeOrder.setUpdater(updater);
            tradeOrder.setUpdateDatatime(now);
            tradeOrder.setRemark(StringUtils.isNotBlank(remark) ? remark
                    : "已标记付款，待释放");
            count = tradeOrderDAO.updateMarkPay(tradeOrder);
        }
        return count;
    }

    @Override
    public int release(TradeOrder tradeOrder, String updater, String remark) {
        int count = 0;
        if (tradeOrder != null) {
            Date now = new Date();
            tradeOrder.setStatus(ETradeOrderStatus.RELEASED.getCode());
            tradeOrder.setReleaseDatetime(now);
            tradeOrder.setUpdater(updater);
            tradeOrder.setUpdateDatatime(now);
            tradeOrder.setRemark(StringUtils.isNotBlank(remark) ? remark
                    : "已释放，待评价");
            count = tradeOrderDAO.updateRelease(tradeOrder);
        }
        return count;
    }

    @Override
    public int doBsComment(TradeOrder tradeOrder, String userId,
            String comment, String status, String remark) {
        int count = 0;
        if (tradeOrder != null) {
            Date now = new Date();
            tradeOrder.setStatus(status);
            tradeOrder.setBsComment(comment);
            tradeOrder.setUpdater(userId);
            tradeOrder.setUpdateDatatime(now);
            tradeOrder.setRemark(remark);
            count = tradeOrderDAO.updateBsComment(tradeOrder);
        }
        return count;
    }

    @Override
    public int doSbComment(TradeOrder tradeOrder, String userId,
            String comment, String status, String remark) {
        int count = 0;
        if (tradeOrder != null) {
            Date now = new Date();
            tradeOrder.setStatus(status);
            tradeOrder.setSbComment(comment);
            tradeOrder.setUpdater(userId);
            tradeOrder.setUpdateDatatime(now);
            tradeOrder.setRemark(remark);
            count = tradeOrderDAO.updateSbComment(tradeOrder);
        }
        return count;
    }

    @Override
    public int applyArbitrate(TradeOrder tradeOrder, String applyUser) {
        int count = 0;
        if (tradeOrder != null) {
            Date now = new Date();
            tradeOrder.setStatus(ETradeOrderStatus.ARBITRATE.getCode());
            tradeOrder.setUpdater(applyUser);
            tradeOrder.setUpdateDatatime(now);
            tradeOrder.setRemark("申请仲裁，待处理");
            count = tradeOrderDAO.updateArbitrate(tradeOrder);
        }
        return count;
    }

    @Override
    public int revokePay(TradeOrder tradeOrder, String updater, String remark) {
        int count = 0;
        if (tradeOrder != null) {
            Date now = new Date();
            tradeOrder.setStatus(ETradeOrderStatus.TO_PAY.getCode());
            tradeOrder.setUpdater(updater);
            tradeOrder.setUpdateDatatime(now);
            tradeOrder.setRemark(remark);
            count = tradeOrderDAO.updateRevokePay(tradeOrder);
        }
        return count;
    }

    @Override
    public List<TradeOrder> queryTradeOrderList(TradeOrder condition) {
        return tradeOrderDAO.selectList(condition);
    }

    @Override
    public TradeOrder getTradeOrder(String code) {
        TradeOrder data = null;
        if (StringUtils.isNotBlank(code)) {
            TradeOrder condition = new TradeOrder();
            condition.setCode(code);
            data = tradeOrderDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(), "编号为"
                        + code + "的交易订单不存在");
            }
        }
        return data;
    }

    @Override
    public boolean isExistOningOrder(String adsCode) {
        boolean flag = false;
        // 检查该广告是否有未完成的订单
        List<String> statusList = new ArrayList<String>();
        statusList.add(ETradeOrderStatus.TO_PAY.getCode());
        statusList.add(ETradeOrderStatus.PAYED.getCode());
        statusList.add(ETradeOrderStatus.ARBITRATE.getCode());
        TradeOrder condition = new TradeOrder();
        condition.setAdsCode(adsCode);
        condition.setStatusList(statusList);
        if (this.getTotalCount(condition) > 0) {
            flag = true;
        }
        return flag;
    }

}
