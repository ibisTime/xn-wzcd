package com.cdkj.coin.ao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.coin.ao.ITradeOrderAO;
import com.cdkj.coin.bo.IAccountBO;
import com.cdkj.coin.bo.IAdsBO;
import com.cdkj.coin.bo.IArbitrateBO;
import com.cdkj.coin.bo.ISYSConfigBO;
import com.cdkj.coin.bo.ITradeOrderBO;
import com.cdkj.coin.bo.IUserBO;
import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.common.SysConstants;
import com.cdkj.coin.domain.Ads;
import com.cdkj.coin.domain.TradeOrder;
import com.cdkj.coin.enums.EAdsStatus;
import com.cdkj.coin.enums.EJourBizTypePlat;
import com.cdkj.coin.enums.EJourBizTypeUser;
import com.cdkj.coin.enums.ESysUser;
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
    private IUserBO userBO;

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
        Ads ads = adsBO.adsSellDetail(adsCode);
        if (!EAdsStatus.DAIJIAOYI.getCode().equals(ads.getStatus())
                && !EAdsStatus.JIAOYIZHONG.getCode().equals(ads.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "广告未上架，不能进行交易");
        }
        if (buyUser.equals(ads.getUserId())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "您是广告发布者，不能进行购买操作");
        }
        // 交易金额校验
        doAmountCheck(ads, tradePrice, count, tradeAmount);
        // 计算交易手续费
        Double rate = sysConfigBO.getDoubleValue(SysConstants.TRADE_FEE_RATE);
        BigDecimal fee = count.multiply(BigDecimal.valueOf(rate));
        // 变更广告剩余可售金额
        adsBO.changeLeftAmount(ads.getCode(), count.negate());
        // 提交交易订单
        code = tradeOrderBO.buySubmit(ads, buyUser, tradePrice, count,
            tradeAmount, fee);
        return code;
    }

    @Override
    public String sell(String adsCode, String sellUser, BigDecimal tradePrice,
            BigDecimal count, BigDecimal tradeAmount) {
        String code = null;
        // to 卖出逻辑
        return code;
    }

    @Override
    @Transactional
    public void cancel(String code, String updater, String remark) {
        TradeOrder tradeOrder = tradeOrderBO.getTradeOrder(code);
        if (!ETradeOrderStatus.TO_PAY.getCode().equals(tradeOrder.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前状态下不能取消订单");
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
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前状态下不能标记已打款");
        }
        // 变更交易订单信息
        tradeOrderBO.markPay(tradeOrder, updater, remark);
    }

    @Override
    @Transactional
    public TradeOrder release(String code, String updater, String remark) {
        TradeOrder tradeOrder = tradeOrderBO.getTradeOrder(code);
        if (!ETradeOrderStatus.PAYED.getCode().equals(tradeOrder.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "当前状态下不能释放");
        }
        if (ETradeOrderType.BUY.getCode().equals(tradeOrder.getType())) {
            doTransferBuy(tradeOrder); // 购买订单划转业务处理
        } else if (ETradeOrderType.SELL.getCode().equals(tradeOrder.getType())) {
            doTransferSell(tradeOrder); // 出售订单划转业务处理
        } else {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "未识别的订单类型");
        }
        // 变更交易订单信息
        tradeOrderBO.release(tradeOrder, updater, remark);
        // 检查广告是否还有交易中的状态，维护状态字段
        adsBO.refreshStatus(tradeOrderBO.isExistOningOrder(tradeOrder
            .getAdsCode()));
        return tradeOrder;
    }

    @Override
    @Transactional
    public void comment(String code, String userId, String comment) {
        TradeOrder tradeOrder = tradeOrderBO.getTradeOrder(code);
        if (!ETradeOrderStatus.RELEASED.getCode()
            .equals(tradeOrder.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "当前状态下不能评价");
        }
        if (userId.equals(tradeOrder.getBuyUser())) {
            doBsComment(tradeOrder, userId, comment); // 买家对卖家进行评论
        } else if (userId.equals(tradeOrder.getSellUser())) {
            doSbComment(tradeOrder, userId, comment); // 卖家对买家进行评论
        } else {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "您无权评价该交易订单");
        }
    }

    @Override
    @Transactional
    public void applyArbitrate(String code, String applyUser, String reason,
            String attach) {
        TradeOrder tradeOrder = tradeOrderBO.getTradeOrder(code);
        if (!ETradeOrderStatus.PAYED.getCode().equals(tradeOrder.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前状态下不能申请仲裁");
        }
        String yuangao = applyUser; // 原告
        String beigao = null; // 被告
        if (applyUser.equals(tradeOrder.getBuyUser())) {
            beigao = tradeOrder.getSellUser();
        } else if (applyUser.equals(tradeOrder.getSellUser())) {
            beigao = tradeOrder.getBuyUser();
        } else {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "您无权申请仲裁");
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
        String remark = "买家已评价，等待卖家评价";
        if (StringUtils.isNotBlank(tradeOrder.getBsComment())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "您已经完成评价，请勿重复评价");
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
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "您已经完成评价，请勿重复评价");
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
            tradeOrder.getTradeCoin(), ESysUser.SYS_USER_ETH.getCode(),
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
            tradeOrder.getTradeCoin(), ESysUser.SYS_USER_ETH.getCode(),
            tradeOrder.getTradeCoin(), tradeOrder.getFee(),
            EJourBizTypeUser.AJ_TRADEFEE.getCode(),
            EJourBizTypePlat.AJ_TRADEFEE.getCode(),
            EJourBizTypeUser.AJ_TRADEFEE.getValue(),
            EJourBizTypePlat.AJ_TRADEFEE.getValue(), tradeOrder.getCode());
    }

    private void doAmountCheck(Ads adsSell, BigDecimal tradePrice,
            BigDecimal count, BigDecimal tradeAmount) {
        if (tradePrice.multiply(count).subtract(tradeAmount).abs()
            .compareTo(BigDecimal.ONE) > 0) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "交易总额计算有误");
        }
        if (adsSell.getMinTrade().compareTo(tradeAmount) > 0) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "交易金额未达最低限额");
        }
        if (adsSell.getMaxTrade().compareTo(tradeAmount) < 0) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "交易金额超过最高限额");
        }
        if (adsSell.getLeftAmount().compareTo(count) < 0) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "交易数量超过剩余可售数量");
        }
    }

    @Override
    public Paginable<TradeOrder> queryTradeOrderPage(int start, int limit,
            TradeOrder condition) {
        Paginable<TradeOrder> results = tradeOrderBO.getPaginable(start, limit,
            condition);
        for (TradeOrder tradeOrder : results.getList()) {
            tradeOrder.setBuyUserInfo(userBO.getUser(tradeOrder.getBuyUser()));
            tradeOrder
                .setSellUserInfo(userBO.getUser(tradeOrder.getSellUser()));
        }
        return results;
    }

    @Override
    public List<TradeOrder> queryTradeOrderList(TradeOrder condition) {
        return tradeOrderBO.queryTradeOrderList(condition);
    }

    @Override
    public TradeOrder getTradeOrder(String code) {
        TradeOrder tradeOrder = tradeOrderBO.getTradeOrder(code);
        tradeOrder.setBuyUserInfo(userBO.getUser(tradeOrder.getBuyUser()));
        tradeOrder.setSellUserInfo(userBO.getUser(tradeOrder.getSellUser()));
        return tradeOrder;
    }

}
