package com.cdkj.coin.ao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.cdkj.coin.bo.*;
import com.cdkj.coin.dao.base.Order;
import com.cdkj.coin.domain.Account;
import com.cdkj.coin.domain.UserStatistics;
import com.cdkj.coin.enums.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;

import com.cdkj.coin.ao.ITradeOrderAO;
import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.common.SysConstants;
import com.cdkj.coin.domain.Ads;
import com.cdkj.coin.domain.TradeOrder;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.EBizErrorCode;
import sun.management.snmp.AdaptorBootstrap;
import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl;

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

    @Autowired
    private IUserRelationBO userRelationBO;

    //我要买币
    @Override
    @Transactional
    public String buy(String adsCode, String buyUser, BigDecimal tradePrice,
                      BigDecimal count, BigDecimal tradeAmount) {

        String code = null;

        //检查购买用户，是否有未完成的订单, 有未完成的交易则不能在进行交易
        if (this.tradeOrderBO.checkUserHasUnFinishOrder(buyUser, ETradeOrderType.BUY)) {

            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "您有尚未完成的购买订单");

        }

        // 获取广告详情
        Ads ads = adsBO.adsDetail(adsCode);

        //校验广告状态，和广告 与 购买者的关系
        this.checkAdsStatusAndMasterCannotBuy(ads, buyUser);

        // 交易金额校验
        doAmountCheck(ads, tradePrice, count, tradeAmount);

        // 计算交易手续费
        Double rate = sysConfigBO.getDoubleValue(SysConstants.TRADE_FEE_RATE);
        BigDecimal fee = count.multiply(BigDecimal.valueOf(rate));

        // 变更广告剩余 可售数量
        adsBO.cutLeftCount(ads.getCode(), count);

        // 提交交易订单
        code = tradeOrderBO.buySubmit(ads, buyUser, tradePrice, count,
                tradeAmount, fee);

        return code;

    }

    //我要卖币
    @Override
    @Transactional
    public String sell(String adsCode, String sellUser, BigDecimal tradePrice,
                       BigDecimal tradeCount, BigDecimal tradeAmount) {

        //
        if (this.tradeOrderBO.checkUserHasUnFinishOrder(sellUser, ETradeOrderType.SELL)) {

            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "您有尚未完成的出售订单");

        }

        //获取广告详情
        Ads ads = this.adsBO.adsDetail(adsCode);
        if (ads == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "广告不存在");
        }

        //校验广告
        this.checkAdsStatusAndMasterCannotBuy(ads, sellUser);

        //必须为买币广告购买广告
        if (!ads.getTradeType().equals(ETradeType.BUY.getCode())) {

            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "该广告不是购买广告");
        }

        //交易额是否大于单笔最大
        if (tradeAmount.compareTo(ads.getMinTrade()) < 0 || tradeAmount.compareTo(ads.getMaxTrade()) > 0) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "交易额需大于等于单笔最小交易额，小于等于单笔最大交易额");
        }

        //校验广告剩余量
        if (ads.getLeftCount().compareTo(tradeCount) < 0) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "交易数量大于可交易数量");
        }

        //校验出售者余额
        Account sellUserAccount = this.accountBO.getAccountByUser(sellUser, ECoin.ETH.getCode());
        if (sellUserAccount.getAmount().subtract(sellUserAccount.getFrozenAmount()).compareTo(tradeCount) < 0) {

            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "您的" + ECoin.ETH.getCode() + "可用余额不足");

        }

        // 计算交易手续费
        Double rate = sysConfigBO.getDoubleValue(SysConstants.TRADE_FEE_RATE);
        BigDecimal fee = tradeCount.multiply(BigDecimal.valueOf(rate));

        //提交订单
        String code = null;
        code = tradeOrderBO.sellSubmit(ads, sellUser, tradePrice, tradeCount, tradeAmount, fee);

        //改变广告可交易量
        this.adsBO.cutLeftCount(ads.getCode(), tradeCount);

        //冻结卖家 数字货币
        this.accountBO.frozenAmount(sellUserAccount, tradeCount, EJourBizTypeUser.AJ_ADS_FROZEN.getCode(), EJourBizTypeUser.AJ_ADS_FROZEN.getValue() + "-提交卖出订单", code);

        return code;
    }

    //校验广告交易状态，主人不能 购买 或者 出售
    private void checkAdsStatusAndMasterCannotBuy(Ads ads, String applyUser) {

        if (ads.getOnlyTrust().equals("1")) {

            if (!this.userRelationBO.checkReleation(ads.getUserId(), applyUser)) {

                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "您未被广告发布者信任，不能与之进行交易");

            }

        }

        if (!EAdsStatus.DAIJIAOYI.getCode().equals(ads.getStatus())
                && !EAdsStatus.JIAOYIZHONG.getCode().equals(ads.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "广告未上架，不能进行交易");
        }
        if (applyUser.equals(ads.getUserId())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "您是广告发布者，不能进行该操作");
        }
    }


    @Override
    @Transactional
    public void cancel(String code, String updater, String remark) {
        TradeOrder tradeOrder = tradeOrderBO.getTradeOrder(code);
        if (!ETradeOrderStatus.TO_PAY.getCode().equals(tradeOrder.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前状态下不能取消订单");
        }

        TradeOrder order = this.tradeOrderBO.getTradeOrder(code);
        if (order == null) {
            throw new BizException("xn000000", "无效的订单编号");
        }

        // 变更广告信息（状态，剩余可售金额）
        adsBO.addLeftCount(tradeOrder.getAdsCode(), tradeOrder.getCount());
        adsBO.refreshStatus(tradeOrder.getAdsCode(),
                tradeOrderBO.isExistOningOrder(tradeOrder.getAdsCode()));

        if (tradeOrder.getType().equals(ETradeOrderType.SELL)) {
            //由于出售时冻结了，卖家的余额这里需要解冻
            Account sellUserAccount = this.accountBO.getAccountByUser(tradeOrder.getSellUser(), ECoin.ETH.getCode());

            //对卖家冻结金额进行解冻
            this.accountBO.unfrozenAmount(sellUserAccount, tradeOrder.getCount(), EJourBizTypeUser.AJ_ADS_UNFROZEN.getCode(), EJourBizTypeUser.AJ_ADS_UNFROZEN.getValue() + "-取消卖出订单", tradeOrder.getCode());

        } else if (tradeOrder.getType().equals(ETradeOrderType.BUY)) {
            //购买订单
            //由于出售广告，出售时就冻结了 交易金额 + 手续费，所以 购买订单取消，也不需要解冻

        }

        // 变更交易订单信息
        tradeOrderBO.cancel(tradeOrder, updater, remark);
    }

    //标价打款
    @Override
    @Transactional
    public void markPay(String code, String updater, String remark) {
        TradeOrder tradeOrder = tradeOrderBO.getTradeOrder(code);

        //检查该订单是否超时
        if (tradeOrder.getInvalidDatetime().compareTo(new Date()) < 0) {
            //订单已超时
            //取消订单
            this.cancel(tradeOrder.getCode(), "系统", "订单支付超时，系统自动取消");
            return;
        }

        //
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
        adsBO.refreshStatus(tradeOrder.getAdsCode(),
                tradeOrderBO.isExistOningOrder(tradeOrder.getAdsCode()));
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

    // 购买广告， 我要出售
    private void doTransferSell(TradeOrder tradeOrder) {

        //1.卖家 冻结金额减少
        Account sellUserAccount = this.accountBO.getAccountByUser(tradeOrder.getSellUser(), tradeOrder.getTradeCoin());
        //1.1 解冻卖家 冻结金额
        this.accountBO.unfrozenAmount(sellUserAccount, tradeOrder.getCount(), EJourBizTypeUser.AJ_ADS_UNFROZEN.getCode(), EJourBizTypeUser.AJ_ADS_UNFROZEN.getValue() + "-订单释放解冻", tradeOrder.getCode());
        //1.2扣除卖家账户金额
        this.accountBO.changeAmount(sellUserAccount.getAccountNumber(), EChannelType.NBZ, null, null, tradeOrder.getCode(), EJourBizTypeUser.AJ_SELL.getCode(), EJourBizTypeUser.AJ_SELL.getValue(), tradeOrder.getCount().negate());


        //2.0 获取买家账户
        Account buyUserAccount = this.accountBO.getAccountByUser(tradeOrder.getBuyUser(), tradeOrder.getTradeCoin());
        //2.1买家 账户余额增加
        this.accountBO.changeAmount(buyUserAccount.getAccountNumber(), EChannelType.NBZ, null, null, tradeOrder.getCode(), EJourBizTypeUser.AJ_BUY.getCode(), EJourBizTypeUser.AJ_BUY.getValue(), tradeOrder.getCount()
        );
        //2.2买家 扣除交易手续费
        this.accountBO.changeAmount(buyUserAccount.getAccountNumber(),
                EChannelType.NBZ, null, null, tradeOrder.getCode(), EJourBizTypeUser.AJ_TRADEFEE.getCode(), EJourBizTypeUser.AJ_TRADEFEE.getValue(), tradeOrder
                        .getFee().negate()
        );

        //3.1平台 盈亏账户加钱
        this.accountBO.changeAmount(ESystemAccount.SYS_ACOUNT_ETH.getCode(), EChannelType.NBZ, null, null, tradeOrder.getCode(), EJourBizTypePlat.AJ_TRADEFEE.getCode(), EJourBizTypePlat.AJ_TRADEFEE.getValue(), tradeOrder
                .getFee()
        );
    }

    //出售广告处理，我要购买
    private void doTransferBuy(TradeOrder tradeOrder) {

        Account sellUserAccount = this.accountBO.getAccountByUser(tradeOrder.getSellUser(), tradeOrder.getTradeCoin());

        //1.1卖家  交易冻结 金额解冻
        this.accountBO.unfrozenAmount(sellUserAccount, tradeOrder.getCount(), EJourBizTypeUser.AJ_ADS_UNFROZEN.getCode(), EJourBizTypeUser.AJ_ADS_UNFROZEN.getValue(), tradeOrder.getCode());

        //1.2卖家 交易所需手续费 解冻
        this.accountBO.unfrozenAmount(sellUserAccount, tradeOrder.getFee(), EJourBizTypeUser.AJ_ADS_UNFROZEN.getCode(), EJourBizTypeUser.AJ_ADS_UNFROZEN.getValue() + "-手续费解冻", tradeOrder.getCode());

        //1.3卖家 扣除交易金额
        this.accountBO.changeAmount(sellUserAccount.getAccountNumber(), EChannelType.NBZ, null, null, tradeOrder.getCode(), EJourBizTypeUser.AJ_SELL.getCode(), EJourBizTypeUser.AJ_SELL.getValue(), tradeOrder.getCount().negate());

        //1.4卖家 扣除交易手续费
        this.accountBO.changeAmount(sellUserAccount.getAccountNumber(), EChannelType.NBZ, null, null, tradeOrder.getCode(), EJourBizTypeUser.AJ_TRADEFEE.getCode(), EJourBizTypeUser.AJ_TRADEFEE.getValue(), tradeOrder.getFee().negate());

        Account buyUserAccount = this.accountBO.getAccountByUser(tradeOrder.getBuyUser(), tradeOrder.getTradeCoin());

        //2.买家 账户余额增加
        this.accountBO.changeAmount(buyUserAccount.getAccountNumber(), EChannelType.NBZ, null, null, tradeOrder.getCode(), EJourBizTypeUser.AJ_BUY.getCode(), EJourBizTypeUser.AJ_BUY.getValue(), tradeOrder.getCount());

        //3.平台盈亏账户余额增加
        this.accountBO.changeAmount(ESystemAccount.SYS_ACOUNT_ETH.getCode(), EChannelType.NBZ, null, null, tradeOrder.getCode(), EJourBizTypePlat.AJ_TRADEFEE.getCode(), EJourBizTypePlat.AJ_TRADEFEE.getValue(), tradeOrder.getFee());

    }

    private void doAmountCheck(Ads adsSell, BigDecimal tradePrice,
                               BigDecimal count, BigDecimal tradeAmount) {
        if (tradePrice.multiply(Convert.fromWei(count, Unit.ETHER))
                .subtract(tradeAmount).abs().compareTo(BigDecimal.ONE) > 0) {
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
        if (adsSell.getLeftCount().compareTo(count) < 0) {
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

    //定时检验 待支付订单的超时时间
    @Override
    public void doCheckUnpayOrder() {
        TradeOrder condition = new TradeOrder();
        condition.setStatus(ETradeOrderStatus.TO_PAY.getCode());
        condition.setInvalidDatetime(new Date());
        List<TradeOrder> resultList = tradeOrderBO
                .queryTradeOrderList(condition);
        for (TradeOrder tradeOrder : resultList) {
            this.cancel(tradeOrder.getCode(), "系统", "订单支付超时，系统自动取消");
        }
    }

    @Override
    public UserStatistics userStatisticsInfo(String userId) {

        return this.tradeOrderBO.obtainUserStatistics(userId);

    }

    @Override
    public BigDecimal getUserTotalTradeCount(String userId) {

        return this.tradeOrderBO.getUserTotalTradeCount(userId);

    }


}
