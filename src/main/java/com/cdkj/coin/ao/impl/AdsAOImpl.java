package com.cdkj.coin.ao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cdkj.coin.bo.*;
import com.cdkj.coin.domain.*;
import com.cdkj.coin.enums.*;
import org.apache.commons.collections.functors.TruePredicate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.coin.ao.IAdsAO;
import com.cdkj.coin.ao.IMarketAO;
import com.cdkj.coin.bo.IAccountBO;
import com.cdkj.coin.bo.IAdsBO;
import com.cdkj.coin.bo.IAdsDisplayTimeBO;
import com.cdkj.coin.bo.IMarketBO;
import com.cdkj.coin.bo.ISYSConfigBO;
import com.cdkj.coin.bo.ITradeOrderBO;
import com.cdkj.coin.bo.IUserBO;
import com.cdkj.coin.bo.IUserRelationBO;
import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.common.SysConstants;
import com.cdkj.coin.core.OrderNoGenerater;
import com.cdkj.coin.domain.Account;
import com.cdkj.coin.domain.Ads;
import com.cdkj.coin.domain.AdsDisplayTime;
import com.cdkj.coin.domain.Market;
import com.cdkj.coin.domain.User;
import com.cdkj.coin.domain.UserStatistics;
import com.cdkj.coin.dto.req.XN625220Req;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.EBizErrorCode;
import org.web3j.utils.Convert;

import javax.rmi.CORBA.Util;

/**
 * Created by tianlei on 2017/十一月/14.
 * 1.发布： a.卖币广告是发布广告的时候就把出售金额 和 手续费冻结了
 * b.买币广告没有冻结
 * 2.购买： a. 卖币广告，改变广告的可售余额即可
 * b.买币广告，冻结卖家金额，同时改变广告可购买金额
 * 3.取消:  a. 卖币广告，改变广告的可售金额即可
 * b.买币广告，需要把 卖家冻结的金额返还
 * 4.释放   a. 卖币广告，卖家冻结金额减少,买家账户余额增加
 * b. 买币广告，卖家冻结金额减少，买家账户余额增加(扣除手续费之后)
 */
@Service
public class AdsAOImpl implements IAdsAO {

    @Autowired
    IMarketBO marketBO;

    @Autowired
    ISYSConfigBO sysConfigBO;

    @Autowired
    IMarketAO marketAO;

    @Autowired
    IAccountBO accountBO;

    @Autowired
    IAdsBO iAdsBO;

    @Autowired
    ITradeOrderBO tradeOrderBO;

    @Autowired
    IAdsDisplayTimeBO displayTimeBO;

    @Autowired
    IUserBO userBO;

    @Autowired
    IUserRelationBO userRelationBO;

    @Override
    public Object frontPage(Integer start, Integer limit, Ads condition) {

        Paginable<Ads> paginable = this.iAdsBO.frontPage(start, limit,
                condition);
        List<Ads> adsList = paginable.getList();
        for (Ads ads : adsList) {
            this.getAdsMasterAndSetMaster(ads);
        }
        return paginable;

    }

    @Override
    public Object ossPage(Integer start, Integer limit, Ads condition) {

        Paginable<Ads> paginable = this.iAdsBO.ossPage(start, limit, condition);
        List<Ads> adsList = paginable.getList();

        for (Ads ads : adsList) {

            this.getAdsMasterAndSetMaster(ads);

        }
        return paginable;

    }

    private void getAdsMasterAndSetMaster(Ads ads) {

        User user = this.userBO.getUser(ads.getUserId());
        ads.setUser(user);
        UserStatistics userStatistics = this.tradeOrderBO
                .obtainUserStatistics(ads.getUserId());

        // 获取信任数量
        userStatistics.setBeiXinRenCount(this.userRelationBO
                .getRelationCount(ads.getUserId()));
        ads.setUserStatistics(userStatistics);

    }

    @Override
    public List<Ads> frontSearchAdsByNickName(String nickName) {

        // 先搜索出 复合的nick
        User userCondition = new User();
        userCondition.setNickname(nickName);

        List<User> userList = this.userBO.queryUserList(userCondition);
        if (userList.isEmpty()) {
            return new ArrayList<>();
        }

        //
        List<Ads> adsList = new ArrayList<>();
        for (User user : userList) {

            Ads condition = new Ads();
            condition.setUserId(user.getUserId());
            Paginable<Ads> adsPaginable = (Paginable) this.frontPage(0, 10,
                    condition);
            //
            adsList.addAll(adsPaginable.getList());

        }

        return adsList;

    }

    @Override
    public void publishAds(XN625220Req req) {

        // 校验用户是否存在
        User user = this.userBO.getUser(req.getUserId());
        if (user == null) {
            throw new BizException("xn00000", "用户不存在");
        }

        //检查是否存在已上架的——同类型的广告
        long count = this.iAdsBO.totalCountOfShangJiaAds(req.getUserId(),
                req.getTradeType());
        if (count > 0) {
            if (req.getTradeType().equals(ETradeOrderType.BUY)) {

                throw new BizException("xn000", "您已经有一个已上架的购买广告");

            } else {

                throw new BizException("xn000", "您已经有一个已上架的出售广告");

            }

        }

        if (req.getTradeType().equals(ETradeType.SELL.getCode())) {

            this.insertSellAds(req);

        } else if (req.getTradeType().equals(ETradeType.BUY.getCode())) {

            this.insertBuyAds(req);

        }

    }

    // 草稿code传入已存在的
    // 第一次插入传生成的
    Ads buildAdsSell(XN625220Req req, String adsCode) {

        Ads ads = new Ads();
        ads.setTradeCoin(ECoin.ETH.getCode());
        ads.setCode(adsCode);
        ads.setUserId(req.getUserId());
        ads.setTradeCurrency(req.getTradeCurrency());
        ads.setCreateDatetime(new Date());
        ads.setUpdateDatetime(new Date());
        ads.setPremiumRate(req.getPremiumRate());
        ads.setTotalCount(req.getTotalCount());
        ads.setLeftCount(req.getTotalCount());
        ads.setTradeType(req.getTradeType());

        // 获取市场价格
        Market market = this.marketBO.marketByCoinTypeAndOrigin(
                ECoin.ETH.getCode(), EMarketOrigin.BITFINEX.getCode());
        if (market == null) {
            throw new BizException("xn000", "发布失败");
        }
        ads.setMarketPrice(market.getMid());

        // 获取手续费率
        Double fee = sysConfigBO.getDoubleValue(SysConstants.TRADE_FEE_RATE);
        ads.setFeeRate(BigDecimal.valueOf(fee));
        BigDecimal truePrice = market.getMid().multiply(
                BigDecimal.ONE.add(req.getPremiumRate()));
        ads.setTruePrice(truePrice);
        // 设置保护价
        ads.setProtectPrice(req.getProtectPrice());
        ads.setMaxTrade(req.getMaxTrade());
        ads.setMinTrade(req.getMinTrade());
        ads.setPayType(req.getPayType());
        ads.setPayLimit(req.getPayLimit());
        ads.setLeaveMessage(req.getLeaveMessage());
        ads.setOnlyTrust(req.getOnlyTrust());
        ads.setDisplayTime(req.getDisplayTime());

        if (ads.getMaxTrade().compareTo(ads.getMinTrade()) < 0) {
            throw new BizException("xn000000", "单笔最大交易额需大于等于单笔最小交易额");
        }

        return ads;
    }

    // 插入卖币广告
    @Transactional
    public void insertSellAds(XN625220Req req) {

        // 构造,并校验
        Ads ads = this.buildAdsSell(req, OrderNoGenerater.generate("ADS"));

        if (req.getPublishType().equals(EAdsPublishType.DRAFT.getCode())) {

            // 草稿
            ads.setStatus(EAdsStatus.DRAFT.getCode());

        } else {

            // 直接发布
            ads.setStatus(EAdsStatus.DAIJIAOYI.getCode());

            // 判断账户并处理
            this.checkAccountAndHandAccount(ads);

        }

        if (ads.getDisplayTime() != null && !ads.getDisplayTime().isEmpty()) {

            // 有展示时间限制、先插入展示时间
            for (AdsDisplayTime displayTime : ads.getDisplayTime()) {

                displayTime.setAdsCode(ads.getCode());
                // 插入
                this.displayTimeBO.insertDisplayTime(displayTime);

            }

        }

        this.iAdsBO.insertAdsSell(ads);

    }

    @Transactional
    public void insertBuyAds(XN625220Req req) {

        // 构造,并校验
        Ads ads = this.buildAdsSell(req, OrderNoGenerater.generate("ADS"));
        if (req.getPublishType().equals(EAdsPublishType.DRAFT.getCode())) {

            // 草稿
            ads.setStatus(EAdsStatus.DRAFT.getCode());

        } else {

            // 直接发布
            ads.setStatus(EAdsStatus.DAIJIAOYI.getCode());

        }

        if (ads.getDisplayTime() != null && !ads.getDisplayTime().isEmpty()) {

            // 有展示时间限制、先插入展示时间
            for (AdsDisplayTime displayTime : ads.getDisplayTime()) {

                displayTime.setAdsCode(ads.getCode());
                // 插入
                this.displayTimeBO.insertDisplayTime(displayTime);

            }

        }

        this.iAdsBO.insertAdsSell(ads);

    }

    @Transactional
    @Override
    public void draftPublish(XN625220Req req) {

        if (StringUtils.isBlank(req.getAdsCode())) {
            throw new BizException("xn000", "请传入广告编号");
        }

        // 构造 并校验
        Ads ads = this.buildAdsSell(req, req.getAdsCode());
        ads.setStatus(EAdsStatus.DAIJIAOYI.getCode());

        // 如果为卖币,就有对账户进行处理
        if (req.getTradeType().equals(ETradeType.SELL.getCode())) {

            // 判断账户并处理
            this.checkAccountAndHandAccount(ads);

        }

        // 删除原来的展示时间
        this.displayTimeBO.deleteAdsDisplayTimeByAdsCode(ads.getCode());

        // 插入新的展示时间
        if (ads.getDisplayTime() != null && !ads.getDisplayTime().isEmpty()) {
            // 有展示时间限制、先插入展示时间
            for (AdsDisplayTime displayTime : ads.getDisplayTime()) {

                displayTime.setAdsCode(ads.getCode());
                // 插入
                this.displayTimeBO.insertDisplayTime(displayTime);

            }

        }

        //
        this.iAdsBO.draftPublish(ads);

    }

    // 暂时弃用
    // @Transactional
    // public void shangJia(XN625220Req req) {
    //
    // if (StringUtils.isBlank(req.getAdsCode())) {
    // throw new BizException("xn000", "请传入广告编号");
    // }
    //
    // // 构造 并校验
    // Ads ads = this.buildAdsSell(req, req.getAdsCode());
    //
    // // 检查 是否处于下架状态
    // Ads trueAds = this.iAdsBO.adsSellDetail(ads.getCode());
    // if (trueAds.getStatus().equals(EAdsStatus.XIAJIA.getCode())) {
    // throw new BizException(EBizErrorCode.DEFAULT.getCode(),
    // "当前广告不是下架状态，不能进行该操作");
    // }
    //
    // // 判断账户并处理
    // this.checkAccountAndHandAccount(ads);
    //
    // // 删除原来的展示时间
    // this.displayTimeBO.deleteAdsDisplayTimeByAdsCode(ads.getCode());
    //
    // // 插入新的展示时间
    // if (ads != null && !ads.getDisplayTime().isEmpty()) {
    // // 有展示时间限制、先插入展示时间
    // for (AdsDisplayTime displayTime : ads.getDisplayTime()) {
    //
    // displayTime.setAdsCode(ads.getCode());
    // // 插入
    // this.displayTimeBO.insertDisplayTime(displayTime);
    //
    // }
    //
    // }
    //
    // //
    // this.iAdsBO.shangJiaAds(ads.getCode());
    //
    // }

    public void checkAccountAndHandAccount(Ads ads) {

        Account account = this.accountBO.getAccountByUser(ads.getUserId(),
                ads.getTradeCoin());

        // 手续费+发布总额
        Double feeRate = sysConfigBO
                .getDoubleValue(SysConstants.TRADE_FEE_RATE);
        BigDecimal fee = ads.getTotalCount().multiply(BigDecimal.valueOf(feeRate));
        BigDecimal willFrezonAmount = ads.getTotalCount().add(fee);

        // 校验账户余额
        if (account.getAmount().subtract(account.getFrozenAmount())
                .compareTo(willFrezonAmount) < 0) {

            BigDecimal maxSell = account.getAmount().subtract(account.getFrozenAmount()).subtract(fee);
            BigDecimal maxSellEther = Convert.fromWei(maxSell, Convert.Unit.ETHER);
            throw new BizException("xn000", "由于要冻结相应手续费，您最多可以出售" + maxSellEther.toString());
        }

        // 冻结 交易金额
        account = this.accountBO.frozenAmount(account, ads.getTotalCount(),
                EJourBizTypeUser.AJ_ADS_FROZEN.getCode(),
                EJourBizTypeUser.AJ_ADS_FROZEN.getValue(), ads.getCode());

        // 冻结 对应的手续费
        account = this.accountBO.frozenAmount(account, fee,
                EJourBizTypeUser.AJ_ADS_FROZEN.getCode(),
                EJourBizTypeUser.AJ_ADS_FROZEN.getValue() + "-交易手续费冻结",
                ads.getCode());

    }

    @Override
    public Object adsDetail(String adsCode, String searchUserUserId) {

        Ads ads = this.iAdsBO.adsDetail(adsCode);

        // 获取展示时间
        ads.setDisplayTime(this.displayTimeBO.queryList(adsCode));

        // 处理用户相关信息
        this.getAdsMasterAndSetMaster(ads);

        //查询信任关系
        if (StringUtils.isNotBlank(searchUserUserId)) {
            int isTrust = 0;
            if (ads.getUserId().equals(searchUserUserId)) {

                isTrust = 1;

            } else {

                isTrust = this.userRelationBO.checkReleation(searchUserUserId, ads.getUserId()) ? 1 : 0;

            }

            ads.setIsTrust(isTrust);

        }

        return ads;

    }

    @Transactional
    @Override
    public void xiaJiaAds(String adsCode, String userId) {
        Ads ads = iAdsBO.adsDetail(adsCode);

        // 检验状态是否满足下架操作
        if (!EAdsStatus.DAIJIAOYI.getCode().equals(ads.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "当前状态无法下架！");
        }

        // 校验操作者是否是本人
        if (!ads.getUserId().equals(userId)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "您无权下架该广告");
        }

        // 进行下架操作
        this.iAdsBO.xiaJiaAds(ads);

        //买币广告，不需要返还
        // 买币广告 不需要对账户进行处理
        if (ads.getTradeType().equals(ETradeType.BUY.getCode())) {
            return;
        }

        //卖币广告 把冻结金额返还
        // 大于最小返还金额，把金额返还
        BigDecimal minBack = BigDecimal.valueOf(Math.pow(10, 10) - 1);
        if (ads.getLeftCount().compareTo(minBack) > 0) {

            Account sellUserAccount = this.accountBO.getAccountByUser(userId,
                    ECoin.ETH.getCode());

            //解冻 未卖出金额
            this.accountBO.unfrozenAmount(sellUserAccount, ads.getLeftCount(), EJourBizTypeUser.AJ_ADS_UNFROZEN.getCode(), EJourBizTypeUser.AJ_ADS_UNFROZEN.getValue() + "-广告未卖出部分解冻", ads.getCode());

            //返还 未卖出金额
            this.accountBO.changeAmount(sellUserAccount, ads.getLeftCount(), EChannelType.NBZ, null, null, ads
                    .getCode(), EJourBizTypeUser.AJ_ADS_UNFROZEN.getCode(), EJourBizTypeUser.AJ_ADS_UNFROZEN.getValue());

            //todo
            //计算需要返还的手续费
            BigDecimal totalCount = ads.getTotalCount();
            BigDecimal leftAmount = ads.getLeftCount();

            //算出出售比例
            BigDecimal rate = leftAmount.divide(totalCount, BigDecimal.ROUND_UP);
            //算出应该退还的手续费
            BigDecimal backFee = totalCount.multiply(ads.getFeeRate()).multiply(BigDecimal.ONE.subtract(rate));

            //大于最小返还金额
            if (backFee.compareTo(minBack) > 0) {

                //手续费-解冻 未卖出金额
                this.accountBO.unfrozenAmount(sellUserAccount, backFee, EJourBizTypeUser.AJ_ADS_UNFROZEN.getCode(), EJourBizTypeUser.AJ_ADS_UNFROZEN.getValue() + "-广告手续费解冻", ads.getCode());

                //返还 未卖出金额
                this.accountBO.changeAmount(sellUserAccount, backFee, EChannelType.NBZ, null, null, ads
                        .getCode(), EJourBizTypeUser.AJ_ADS_UNFROZEN.getCode(), EJourBizTypeUser.AJ_ADS_UNFROZEN.getValue() + "-广告手续费解冻");

            }

        }

    }

    @Override
    public void checkXiajia(String adsCode) {
        Ads ads = iAdsBO.adsDetail(adsCode);
        if (EAdsStatus.DAIJIAOYI.getCode().equals(ads.getStatus())) {
            // 剩余金额小于 单笔最小交易金额就下架
            boolean condition1 = ads.getLeftCount().compareTo(BigDecimal.ZERO) == 0;
            boolean condition2 = ads.getLeftCount()
                    .compareTo(ads.getMinTrade()) < 0;
            if (condition1 || condition2) {
                iAdsBO.xiaJiaAds(ads);
            }
        }
    }

    // 定时刷新行情价格
    public void refreshMarketPrice() {

        Market market = this.marketBO.marketByCoinTypeAndOrigin(
                ECoin.ETH.getCode(), EMarketOrigin.BITFINEX.getCode());
        // 1.只刷新上架状态的
        List<Ads> shangJiaAdsList = this.iAdsBO.queryShangJiaAdsList();
        for (Ads ads : shangJiaAdsList) {

            ads.setMarketPrice(market.getMid());
            // 行情价格
            // 真实价格
            // 取出溢价率
            BigDecimal premiumRate = ads.getPremiumRate();

            // 算出 溢价之后的价格
            BigDecimal truePrice = market.getMid().multiply(
                    BigDecimal.ONE.add(premiumRate));
            BigDecimal protectPrice = ads.getProtectPrice();

            if (ads.getTradeType().equals(ETradeType.SELL)) {

                truePrice = truePrice.compareTo(protectPrice) > 0 ? truePrice
                        : protectPrice;

            } else if (ads.getTradeType().equals(ETradeType.BUY)) {

                truePrice = truePrice.compareTo(protectPrice) < 0 ? truePrice
                        : protectPrice;

            } else {

                continue;

            }
            ads.setTruePrice(truePrice);
            // 只更新行情 和 真实价格
            this.iAdsBO.updateAdsPriceByPrimaryKey(ads);

        }

    }

}
