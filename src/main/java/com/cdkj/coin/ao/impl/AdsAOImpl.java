package com.cdkj.coin.ao.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.coin.ao.IAdsAO;
import com.cdkj.coin.ao.IMarketAO;
import com.cdkj.coin.bo.IAccountBO;
import com.cdkj.coin.bo.IAdsDisplayTimeBO;
import com.cdkj.coin.bo.IAdsBO;
import com.cdkj.coin.bo.IMarketBO;
import com.cdkj.coin.bo.ISYSConfigBO;
import com.cdkj.coin.bo.ITradeOrderBO;
import com.cdkj.coin.bo.IUserBO;
import com.cdkj.coin.common.SysConstants;
import com.cdkj.coin.core.OrderNoGenerater;
import com.cdkj.coin.domain.Account;
import com.cdkj.coin.domain.AdsDisplayTime;
import com.cdkj.coin.domain.Ads;
import com.cdkj.coin.domain.Market;
import com.cdkj.coin.domain.User;
import com.cdkj.coin.dto.req.XN625220Req;
import com.cdkj.coin.enums.EAdsPublishType;
import com.cdkj.coin.enums.EAdsStatus;
import com.cdkj.coin.enums.ECoin;
import com.cdkj.coin.enums.EJourBizTypeUser;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.EBizErrorCode;

/**
 * Created by tianlei on 2017/十一月/14.
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
    IUserBO userBO;

    @Autowired
    IAdsDisplayTimeBO displayTimeBO;

    @Override
    public Object frontSellPage(Integer start, Integer limit, Ads condition) {

        return this.iAdsBO.frontSellPage(start, limit, condition);

    }

    @Override
    public Object ossSellPage(Integer start, Integer limit, Ads condition) {

        return this.iAdsBO.ossSellPage(start, limit, condition);

    }

    @Override
    public void insertAds(XN625220Req req) {

        // 校验用户是否存在
        User user = this.userBO.getUser(req.getUserId());
        if (user == null) {
            throw new BizException("xn00000", "用户不存在");
        }

        this.insertSellAds(req);

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
        ads.setTotalAmount(req.getTotalAmount());
        ads.setLeftAmount(req.getTotalAmount());

        // 获取市场价格
        Market market = this.marketAO.marketByCoinType(ECoin.ETH.getCode());
        if (market == null) {
            throw new BizException("xn000", "发布失败");
        }
        ads.setMarketPrice(market.getMid());
        // 设置保护价
        ads.setProtectPrice(req.getProtectPrice());
        ads.setMaxTrade(req.getMaxTrade());
        ads.setMinTrade(req.getMinTrade());
        ads.setPayType(req.getPayType());
        ads.setPayLimit(req.getPayLimit());
        ads.setLeaveMessage(req.getLeaveMessage());
        ads.setOnlyTrust(req.getOnlyTrust());
        ads.setDisplayTime(req.getDisplayTime());

        if (ads.getMaxTrade().compareTo(ads.getMinTrade()) <= 0) {
            throw new BizException("xn000000", "单笔最大交易额需大于等于单笔最小交易额");
        }

        // 总交易额需大于 最大交易额
        if (ads.getTotalAmount().compareTo(ads.getMaxTrade()) < 0) {
            throw new BizException("xn000000", "最大交易额需小于交易总额");
        }

        return ads;
    }

    @Transactional
    public void insertSellAds(XN625220Req req) {

        // 构造,并校验
        Ads ads = this.buildAdsSell(req, OrderNoGenerater.generate("ADSS"));

        if (req.getPublishType().equals(EAdsPublishType.DRAFT.getCode())) {

            // 草稿
            ads.setStatus(EAdsStatus.DRAFT.getCode());

        } else {

            // 直接发布
            ads.setStatus(EAdsStatus.SHANG_JIA.getCode());

            // 判断账户并处理
            this.checkAccountAndHandAccount(ads);

        }

        if (ads.getDisplayTime() != null && !ads.getDisplayTime().isEmpty()) {

            // 有展示时间限制、先插入展示时间
            for (AdsDisplayTime displayTime : ads.getDisplayTime()) {

                displayTime.setAdsCode(ads.getCode());
                // 校验
                this.displayTimeBO.check(displayTime);
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
        ads.setStatus(EAdsStatus.SHANG_JIA.getCode());

        // 判断账户并处理
        this.checkAccountAndHandAccount(ads);

        // 删除原来的展示时间
        this.displayTimeBO.deleteAdsDisplayTimeByAdsCode(ads.getCode());

        // 插入新的展示时间
        if (ads != null && !ads.getDisplayTime().isEmpty()) {
            // 有展示时间限制、先插入展示时间
            for (AdsDisplayTime displayTime : ads.getDisplayTime()) {

                displayTime.setAdsCode(ads.getCode());
                // 校验
                this.displayTimeBO.check(displayTime);
                // 插入
                this.displayTimeBO.insertDisplayTime(displayTime);

            }

        }

        //
        this.iAdsBO.sellDraftPublish(ads);

    }

    public void checkAccountAndHandAccount(Ads ads) {

        Account account = this.accountBO.getAccountByUser(ads.getUserId(),
                ads.getTradeCoin());

        // 手续费+发布总额
        Double feeRate = sysConfigBO
                .getDoubleValue(SysConstants.TRADE_FEE_RATE);
        BigDecimal fee = ads.getTotalAmount().multiply(new BigDecimal(feeRate));
        BigDecimal frezonAmount = ads.getTotalAmount().add(fee);

        // 校验账户余额
        if (account.getAmount().compareTo(frezonAmount) < 0) {
            throw new BizException("xn000", "需要冻结相应的手续费，账户余额不足");
        }

        // 冻结账户金额
        this.accountBO.frozenAmount(account, ads.getTotalAmount(),
                EJourBizTypeUser.AJ_ADS_FROZEN.getCode(),
                EJourBizTypeUser.AJ_ADS_FROZEN.getValue(), ads.getCode());

    }

    @Override
    public Object adsDetail(String adsCode) {

        return this.iAdsBO.adsSellDetail(adsCode);

    }

    @Transactional
    @Override
    public void xiaJiaAds(String adsCode, String userId) {
        Ads ads = iAdsBO.adsSellDetail(adsCode);
        if (!EAdsStatus.SHANG_JIA.getCode().equals(ads.getStatus())) {
            throw new BizException(
                    EBizErrorCode.DEFAULT_ERROR_CODE.getErrorCode(), "当前状态无法下架！");
        }
        // 校验操作者是否是本人
        if (!ads.getUserId().equals(userId)) {
            throw new BizException(EBizErrorCode.DEFAULT_ERROR_CODE.getErrorCode(), "您无权下架该广告");
        }
        // 检查是否有正在进行中的交易
        tradeOrderBO.checkXiajia(adsCode);

        // 进行下架操作
        this.iAdsBO.xiaJiaAds(ads);

        // 下架成功 把冻结金额返还
        if (ads.getLeftAmount().compareTo(BigDecimal.ZERO) > 0) {

            Account account = this.accountBO.getAccountByUser(userId, ECoin.ETH.getCode());
            this.accountBO.unfrozenAmount(account, ads.getLeftAmount(), "");

        }

    }

    @Override
    public void checkXiajia(String adsCode) {
        Ads ads = iAdsBO.adsSellDetail(adsCode);
        if (!EAdsStatus.SHANG_JIA.getCode().equals(ads.getStatus())) {
            throw new BizException(
                    EBizErrorCode.DEFAULT_ERROR_CODE.getErrorCode(), "当前状态无法下架！");
        }
        // 剩余金额小于 单笔最小交易金额就下架
        boolean condition1 = ads.getLeftAmount().compareTo(
                new BigDecimal(0)) == 0;

        boolean condition2 = ads.getLeftAmount().compareTo(
                ads.getMinTrade()) < 0;
        if (condition1 || condition2) {
            iAdsBO.xiaJiaAds(ads);
        }
    }

}
