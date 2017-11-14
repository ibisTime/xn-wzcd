package com.cdkj.coin.ao.impl;

import com.cdkj.coin.ao.IAdsAO;
import com.cdkj.coin.ao.IMarketAO;
import com.cdkj.coin.bo.IAdsBO;
import com.cdkj.coin.bo.IMarketBO;
import com.cdkj.coin.bo.IUserBO;
import com.cdkj.coin.core.OrderNoGenerater;
import com.cdkj.coin.domain.AdsSell;
import com.cdkj.coin.domain.Market;
import com.cdkj.coin.dto.req.XN625220Req;
import com.cdkj.coin.dto.res.BooleanRes;
import com.cdkj.coin.enums.*;
import com.cdkj.coin.exception.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    IAdsBO iAdsBO;

    @Autowired
    IUserBO userBO;

    public Object frontPage(Integer start, Integer limit, String coin, String tradeType) {

        if (tradeType.equals(ETradeType.SELL.getCode())) {
            //卖币
            return this.iAdsBO.frontSellPage(start,limit,coin);
        }

        return null;

    }

    public Object ossPage(Integer start, Integer limit,String coin,String tradeType) {

        if (tradeType.equals(ETradeType.SELL.getCode())) {
            //卖币
            return this.iAdsBO.ossSellPage(start,limit,coin);
        }

        return null;
    }


    @Override
    public void insertAds(XN625220Req req) {

        //1.校验用户是否存在
//        User user = this.userBO.getUser(req.getUserId());
//        if (user == null) {
//            throw new BizException("xn00000","用户不存在");
//        }

        if (req.getPublishType().endsWith(EAdsPublishType.DRAFT.getCode())) {
            //存草稿

        } else {
            //直接发布
            //检查用户余额
            //冻结用户余额

        }

        //2.构造对象
        AdsSell adsSell = new AdsSell();

        adsSell.setTradeCoin(ECoin.ETH.getCode());
        adsSell.setCode(OrderNoGenerater.generate("ADSS"));
        adsSell.setUserId(req.getUserId());
        adsSell.setTradeCurrency(ECurrency.CNY.getCode());
        adsSell.setCreateDatetime(new Date());
        adsSell.setUpdateDatetime(new Date());
        adsSell.setPremiumRate(req.getPremiumRate());
        adsSell.setTotalAmount(req.getTotalAmount());
        adsSell.setLeftAmount(new BigDecimal("0"));
        //获取市场价格
        Market market = this.marketAO.marketByCoinType(ECoin.ETH.getCode());
        adsSell.setMarketPrice(market.getMid());

        //设置保护价
        adsSell.setProtectPrice(req.getProtectPrice());
        adsSell.setMaxTrade(req.getMaxTrade());
        adsSell.setMinTrade(req.getMinTrade());
        adsSell.setPayType(req.getPayType());
        adsSell.setPayLimit(20);
        adsSell.setLeaveMessage(req.getLeaveMessage());
        adsSell.setOnlyTrust(req.getOnlyTrust());
        adsSell.setDisplayTime(req.getDisplayTime());

        if (req.getPublishType().equals("0")) {

            //草稿
            adsSell.setStatus(EAdsStatus.DRAFT.getCode());

        } else {
            //直接发布
            adsSell.setStatus(EAdsStatus.SHANG_JIA.getCode());

        }


        // 最大交易额，需大于最小交易额
        if (adsSell.getMaxTrade().compareTo(adsSell.getMinTrade()) <= 0) {
            throw new BizException("xn000000", "单笔最大交易额需大于等于单笔最小交易额");
        }

        if (adsSell.getTotalAmount().compareTo(adsSell.getMaxTrade()) < 0) {
            throw new BizException("xn000000", "最大交易额需小于交易总额");
        }
        //可见时间校验
//        if (displayTime != null && !displayTime.isEmpty()) {
//
//            // 每周的一天有一个或者没有
//            String[] weekStr = {"1","2","3","4","5","6","7"};
//
//            Map countMap = new HashMap();
//            for (String day : weekStr) {
//
//                countMap.put(day,new Integer(0));
//
//            }
//
//            for (AdsDisplayTime adsDisplayTime : displayTime) {
//
//                if (StringUtils.isBlank(adsDisplayTime.getWeek())) {
//                    throw new BizException("xn000000","周几不能为空");
//                }
//              Integer count =  countMap.get(adsDisplayTime.get)
//
//            }
//
//        }
        this.iAdsBO.insertAdsSell(adsSell);

    }

    @Override
    public Object adsDetail(String adsCode,String tradeType) {

        if (tradeType.equals(ETradeType.SELL.getCode())) {

        return  this.iAdsBO.adsSellDetail(adsCode);

        } else if (tradeType.equals(ETradeType.BUY.getCode())) {

            return null;

        } else  {

            return null;

        }
    }


}
