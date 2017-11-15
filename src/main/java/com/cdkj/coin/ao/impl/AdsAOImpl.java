package com.cdkj.coin.ao.impl;

import com.cdkj.coin.ao.IAdsAO;
import com.cdkj.coin.ao.IMarketAO;
import com.cdkj.coin.bo.*;
import com.cdkj.coin.core.OrderNoGenerater;
import com.cdkj.coin.dao.IDisplayTimeDAO;
import com.cdkj.coin.domain.*;
import com.cdkj.coin.dto.req.XN625220Req;
import com.cdkj.coin.dto.res.BooleanRes;
import com.cdkj.coin.enums.*;
import com.cdkj.coin.exception.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by tianlei on 2017/十一月/14.
 */
@Service
public class AdsAOImpl implements IAdsAO {

    @Autowired
    IMarketBO marketBO;

    @Autowired
    IMarketAO marketAO;

    @Autowired
    IAccountBO accountBO;

    @Autowired
    IAdsBO iAdsBO;

    @Autowired
    IUserBO userBO;

    @Autowired
    IAdsDisplayTimeBO displayTimeBO;

    public Object frontPage(Integer start, Integer limit, String coin, String tradeType) {

        if (tradeType.equals(ETradeType.SELL.getCode())) {
            //卖币
            return this.iAdsBO.frontSellPage(start, limit, coin);
        }

        return null;

    }

    public Object ossPage(Integer start, Integer limit, String coin, String tradeType) {

        if (tradeType.equals(ETradeType.SELL.getCode())) {
            //卖币
            return this.iAdsBO.ossSellPage(start, limit, coin);
        }

        return null;
    }


    @Override
    public void insertAds(XN625220Req req) {

        //校验用户是否存在
        User user = this.userBO.getUser(req.getUserId());
        if (user == null) {
            throw new BizException("xn00000", "用户不存在");
        }

        if (req.getTradeType().equals(ETradeType.SELL.getCode())) {
            //卖币
            this.insertSellAds(req);

        } else if (req.getTradeType().equals(ETradeType.BUY.getCode())) {
            //买币
        } else {

        }

    }

    @Transactional
    public void insertSellAds(XN625220Req req) {

        AdsSell ads = new AdsSell();
        ads.setTradeCoin(ECoin.ETH.getCode());
        ads.setCode(OrderNoGenerater.generate("ADSS"));
        ads.setUserId(req.getUserId());
        ads.setTradeCurrency(ECurrency.CNY.getCode());
        ads.setCreateDatetime(new Date());
        ads.setUpdateDatetime(new Date());
        ads.setPremiumRate(req.getPremiumRate());
        ads.setTotalAmount(req.getTotalAmount());
        ads.setLeftAmount(req.getTotalAmount());

        //获取市场价格
        Market market = this.marketAO.marketByCoinType(ECoin.ETH.getCode());
        ads.setMarketPrice(market.getMid());

        //设置保护价
        ads.setProtectPrice(req.getProtectPrice());
        ads.setMaxTrade(req.getMaxTrade());
        ads.setMinTrade(req.getMinTrade());
        ads.setPayType(req.getPayType());
        ads.setPayLimit(req.getPayLimit());
        ads.setLeaveMessage(req.getLeaveMessage());
        ads.setOnlyTrust(req.getOnlyTrust());
        ads.setDisplayTime(req.getDisplayTime());

        //2.校验参数
        // 最大交易额
        if (ads.getMaxTrade().compareTo(ads.getMinTrade()) <= 0) {
            throw new BizException("xn000000", "单笔最大交易额需大于等于单笔最小交易额");
        }

        //总交易额需大于 最大交易额
        if (ads.getTotalAmount().compareTo(ads.getMaxTrade()) < 0) {
            throw new BizException("xn000000", "最大交易额需小于交易总额");
        }

        if (req.getPublishType().equals(EAdsPublishType.DRAFT.getCode())) {

            //草稿
            ads.setStatus(EAdsStatus.DRAFT.getCode());

        } else {

            //直接发布
            //冻结账户
            ads.setStatus(EAdsStatus.SHANG_JIA.getCode());
            Account account = this.accountBO.getAccountByUser(ads.getUserId(), ads.getTradeCoin());

            // 校验账户余额
            if (account.getAmount().compareTo(ads.getMaxTrade()) < 0) {
                throw new BizException("xn000", "账户余额不足");
            }

            //冻结账户金额
            account.setFrozenAmount(ads.getMaxTrade());

        }

        if (!ads.getDisplayTime().isEmpty()) {
            //有展示时间限制、先掺入展示时间
            for (AdsDisplayTime displayTime : ads.getDisplayTime()) {

                displayTime.setAdscode(ads.getCode());
                //校验
                this.displayTimeBO.check(displayTime);
                //插入
                this.displayTimeBO.insertDisplayTime(displayTime);

            }

        }
        this.iAdsBO.insertAdsSell(ads);
    }

    @Override
    public void draftPublish(XN625220Req req) {

        this.iAdsBO.sellDraftPublish(null);
    }


    @Override
    public Object adsDetail(String adsCode, String tradeType) {

        if (tradeType.equals(ETradeType.SELL.getCode())) {

            return this.iAdsBO.adsSellDetail(adsCode);

        } else if (tradeType.equals(ETradeType.BUY.getCode())) {

            return null;

        } else {

            return null;

        }
    }

    @Override
    public void xiaJiaAds(String adsCode, String tradeType, String userId) {

        // todo 校验该广告 是否属于该用户
        if (tradeType.equals(ETradeType.SELL.getCode())) {

            this.iAdsBO.xiaJiaAds(adsCode, ETradeType.SELL);

        } else if (tradeType.equals(ETradeType.BUY.getCode())) {

        } else {

        }

    }

}
