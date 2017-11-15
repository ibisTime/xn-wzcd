package com.cdkj.coin.ao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.coin.ao.ITradeOrderAO;
import com.cdkj.coin.bo.IAccountBO;
import com.cdkj.coin.bo.IAdsBO;
import com.cdkj.coin.bo.IArbitrateBO;
import com.cdkj.coin.bo.ISYSConfigBO;
import com.cdkj.coin.bo.ITradeOrderBO;
import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.common.SysConstants;
import com.cdkj.coin.domain.AdsSell;
import com.cdkj.coin.domain.TradeOrder;
import com.cdkj.coin.enums.EJourBizTypePlat;
import com.cdkj.coin.enums.EJourBizTypeUser;
import com.cdkj.coin.enums.ESystemAccount;
import com.cdkj.coin.enums.ETradeOrderStatus;
import com.cdkj.coin.enums.ETradeOrderType;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.EBizErrorCode;

@Service
public class TradeOrderAOImpl implements ITradeOrderAO {

    @Autowired
    private ITradeOrderBO tradeOrderBO;

    @Autowired
    private IAdsBO adsBO;

    @Autowired
    private IArbitrateBO arbitrateBO;

    @Autowired
    private IAccountBO accountBO;

    @Autowired
    private ISYSConfigBO sysConfigBO;

    @Override
    @Transactional
    public String buy(String adsCode, String buyUser, BigDecimal tradePrice,
            BigDecimal count, BigDecimal tradeAmount) {
        String code = null;
        // 获取广告详情
        AdsSell adsSell = adsBO.adsSellDetail(adsCode);
        // 交易金额校验
        doAmountCheck(adsSell, tradePrice, count, tradeAmount);
        // 计算交易手续费
        Double rate = sysConfigBO.getDoubleValue(SysConstants.TRADE_FEE_RATE);
        BigDecimal fee = count.multiply(BigDecimal.valueOf(rate));
        // todo 变更广告信息（状态，剩余可售金额等）
        // 提交交易订单
        code = tradeOrderBO.buySubmit(adsSell, buyUser, tradePrice, count,
            tradeAmount, fee);
        return code;
    }

    @Override
    @Transactional
    public void cancel(String code, String updater, String remark) {
        TradeOrder tradeOrder = tradeOrderBO.getTradeOrder(code);
        if (!ETradeOrderStatus.TO_PAY.getCode().equals(tradeOrder.getStatus())) {
            throw new BizException(
                EBizErrorCode.DEFAULT_ERROR_CODE.getErrorCode(), "当前状态下不能取消订单");
        }
        // todo 变更广告信息（状态，剩余可售金额等）
        // 变更交易订单信息
        tradeOrderBO.cancel(tradeOrder, updater, remark);
    }

    @Override
    @Transactional
    public void markPay(String code, String updater, String remark) {
        TradeOrder tradeOrder = tradeOrderBO.getTradeOrder(code);
        if (!ETradeOrderStatus.TO_PAY.getCode().equals(tradeOrder.getStatus())) {
            throw new BizException(
                EBizErrorCode.DEFAULT_ERROR_CODE.getErrorCode(), "当前状态下不能标记已打款");
        }
        // 变更交易订单信息
        tradeOrderBO.markPay(tradeOrder, updater, remark);
    }

    @Override
    @Transactional
    public void release(String code, String updater, String remark) {
        TradeOrder tradeOrder = tradeOrderBO.getTradeOrder(code);
        if (!ETradeOrderStatus.PAYED.getCode().equals(tradeOrder.getStatus())) {
            throw new BizException(
                EBizErrorCode.DEFAULT_ERROR_CODE.getErrorCode(), "当前状态下不能释放");
        }
        if (ETradeOrderType.BUY.getCode().equals(tradeOrder.getType())) {
            doTransferBuy(tradeOrder); // 购买订单划转业务处理
        } else if (ETradeOrderType.SELL.getCode().equals(tradeOrder.getType())) {
            doTransferSell(tradeOrder); // 出售订单划转业务处理
        } else {
            throw new BizException(
                EBizErrorCode.DEFAULT_ERROR_CODE.getErrorCode(), "未识别的订单类型");
        }
        // 变更交易订单信息
        tradeOrderBO.release(tradeOrder, updater, remark);
    }

    @Override
    @Transactional
    public void comment(String code, String userId, String comment) {
        TradeOrder tradeOrder = tradeOrderBO.getTradeOrder(code);
        if (!ETradeOrderStatus.RELEASED.getCode()
            .equals(tradeOrder.getStatus())) {
            throw new BizException(
                EBizErrorCode.DEFAULT_ERROR_CODE.getErrorCode(), "当前状态下不能评价");
        }
        if (userId.equals(tradeOrder.getBuyUser())) {
            doBsComment(tradeOrder, userId, comment); // 买家对卖家进行评论
        } else if (userId.equals(tradeOrder.getSellUser())) {
            doSbComment(tradeOrder, userId, comment); // 卖家对买家进行评论
        } else {
            throw new BizException(
                EBizErrorCode.DEFAULT_ERROR_CODE.getErrorCode(), "您无权评价该交易订单");
        }
    }

    @Override
    @Transactional
    public void applyArbitrate(String code, String applyUser, String reason,
            String attach) {
        TradeOrder tradeOrder = tradeOrderBO.getTradeOrder(code);
        if (!ETradeOrderStatus.PAYED.getCode().equals(tradeOrder.getStatus())) {
            throw new BizException(
                EBizErrorCode.DEFAULT_ERROR_CODE.getErrorCode(), "当前状态下不能申请仲裁");
        }
        String yuangao = applyUser; // 原告
        String beigao = null; // 被告
        if (applyUser.equals(tradeOrder.getBuyUser())) {
            beigao = tradeOrder.getSellUser();
        } else if (applyUser.equals(tradeOrder.getSellUser())) {
            beigao = tradeOrder.getBuyUser();
        } else {
            throw new BizException(
                EBizErrorCode.DEFAULT_ERROR_CODE.getErrorCode(), "您无权申请仲裁");
        }
        // 更新交易订单信息
        tradeOrderBO.applyArbitrate(tradeOrder, applyUser);
        // 提交仲裁工单
        arbitrateBO.submit(tradeOrder.getCode(), yuangao, beigao, reason,
            attach);
    }

    private void doBsComment(TradeOrder tradeOrder, String userId,
            String comment) {
        String status = tradeOrder.getStatus();
        String remark = "买已评价，等待卖家评价";
        if (StringUtils.isNotBlank(tradeOrder.getBsComment())) {
            throw new BizException(
                EBizErrorCode.DEFAULT_ERROR_CODE.getErrorCode(), "您已经完成评价");
        }
        // 如果卖家已经评价过，订单完成
        if (StringUtils.isNotBlank(tradeOrder.getSbComment())) {
            status = ETradeOrderStatus.COMPLETE.getCode();
            remark = "订单已完成";
        }
        tradeOrderBO.doBsComment(tradeOrder, userId, comment, status, remark);
    }

    private void doSbComment(TradeOrder tradeOrder, String userId,
            String comment) {
        String status = tradeOrder.getStatus();
        String remark = "卖家已评价，等待买家评价";
        if (StringUtils.isNotBlank(tradeOrder.getSbComment())) {
            throw new BizException(
                EBizErrorCode.DEFAULT_ERROR_CODE.getErrorCode(), "您已经完成评价");
        }
        // 如果买家已经评价过，订单完成
        if (StringUtils.isNotBlank(tradeOrder.getBsComment())) {
            status = ETradeOrderStatus.COMPLETE.getCode();
            remark = "订单已完成";
        }
        tradeOrderBO.doSbComment(tradeOrder, userId, comment, status, remark);
    }

    private void doTransferSell(TradeOrder tradeOrder) {
        // 1、卖家转账至买家
        accountBO.transAmountCZB(tradeOrder.getSellUser(),
            tradeOrder.getTradeCoin(), tradeOrder.getBuyUser(),
            tradeOrder.getTradeCoin(), tradeOrder.getCount(),
            EJourBizTypeUser.AJ_SELL.getCode(),
            EJourBizTypeUser.AJ_BUY.getCode(),
            EJourBizTypeUser.AJ_SELL.getValue(),
            EJourBizTypeUser.AJ_BUY.getValue(), tradeOrder.getCode());
        // 2、向买家收手续费
        accountBO.transAmountCZB(tradeOrder.getBuyUser(),
            tradeOrder.getTradeCoin(), ESystemAccount.SYS_ACOUNT_ETH.getCode(),
            tradeOrder.getTradeCoin(), tradeOrder.getFee(),
            EJourBizTypeUser.AJ_TRADEFEE.getCode(),
            EJourBizTypePlat.AJ_TRADEFEE.getCode(),
            EJourBizTypeUser.AJ_TRADEFEE.getValue(),
            EJourBizTypePlat.AJ_TRADEFEE.getValue(), tradeOrder.getCode());
    }

    private void doTransferBuy(TradeOrder tradeOrder) {
        // 1、卖家转账至买家
        accountBO.transAmountCZB(tradeOrder.getSellUser(),
            tradeOrder.getTradeCoin(), tradeOrder.getBuyUser(),
            tradeOrder.getTradeCoin(), tradeOrder.getCount(),
            EJourBizTypeUser.AJ_SELL.getCode(),
            EJourBizTypeUser.AJ_BUY.getCode(),
            EJourBizTypeUser.AJ_SELL.getValue(),
            EJourBizTypeUser.AJ_BUY.getValue(), tradeOrder.getCode());
        // 2、向卖家收手续费
        accountBO.transAmountCZB(tradeOrder.getSellUser(),
            tradeOrder.getTradeCoin(), ESystemAccount.SYS_ACOUNT_ETH.getCode(),
            tradeOrder.getTradeCoin(), tradeOrder.getFee(),
            EJourBizTypeUser.AJ_TRADEFEE.getCode(),
            EJourBizTypePlat.AJ_TRADEFEE.getCode(),
            EJourBizTypeUser.AJ_TRADEFEE.getValue(),
            EJourBizTypePlat.AJ_TRADEFEE.getValue(), tradeOrder.getCode());
    }

    private void doAmountCheck(AdsSell adsSell, BigDecimal tradePrice,
            BigDecimal count, BigDecimal tradeAmount) {
        if (tradePrice.multiply(count).subtract(tradeAmount).abs()
            .compareTo(BigDecimal.ONE) > 0) {
            throw new BizException(
                EBizErrorCode.DEFAULT_ERROR_CODE.getErrorCode(), "交易总额计算有误");
        }
        if (adsSell.getMinTrade().compareTo(tradeAmount) > 0) {
            throw new BizException(
                EBizErrorCode.DEFAULT_ERROR_CODE.getErrorCode(), "交易金额未达最低限额");
        }
        if (adsSell.getMaxTrade().compareTo(tradeAmount) < 0) {
            throw new BizException(
                EBizErrorCode.DEFAULT_ERROR_CODE.getErrorCode(), "交易金额超过最高限额");
        }
        if (adsSell.getLeftAmount().compareTo(tradeAmount) < 0) {
            throw new BizException(
                EBizErrorCode.DEFAULT_ERROR_CODE.getErrorCode(), "交易金额超过剩余可售金额");
        }
    }

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
