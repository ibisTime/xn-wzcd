package com.cdkj.coin.ao.impl;

import com.cdkj.coin.ao.IAdsAO;
import com.cdkj.coin.ao.IMarketAO;
import com.cdkj.coin.bo.IMarketBO;
import com.cdkj.coin.common.StringUtil;
import com.cdkj.coin.core.OrderNoGenerater;
import com.cdkj.coin.domain.AdsSell;
import com.cdkj.coin.domain.Market;
import com.cdkj.coin.dto.req.XN625220Req;
import com.cdkj.coin.enums.EBoolean;
import com.cdkj.coin.enums.ECoin;
import com.cdkj.coin.exception.BizException;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

  


    @Override
    public Object insertAds(String userId, String tradeCurrency, String tradeCoin, String onlyTrust, BigDecimal premiumRate, BigDecimal totalAmount, BigDecimal leftAmount, BigDecimal protectPrice, BigDecimal minTrade, BigDecimal maxTrade, String payType, Integer payLimit,  String leaveMessage) {

        //1.校验用户是否存在
        //2.构造对象
        AdsSell adsSell = new AdsSell();
        adsSell.setCode(OrderNoGenerater.generate("ADSS"));
        adsSell.setUserId(userId);
        adsSell.setTradeCurrency(ECoin.ETH.getCode());
        adsSell.setCreateDatetime(new Date());
        adsSell.setUpdateDatetime(new Date());

        adsSell.setPremiumRate(premiumRate);
        adsSell.setTotalAmount(totalAmount);
        adsSell.setLeftAmount(new BigDecimal("0"));

        //获取市场价格
        Market market = this.marketAO.marketByCoinType(ECoin.ETH.getCode());
        adsSell.setMarketPrice(market.getMid());

        //设置保护价
        adsSell.setProtectPrice(protectPrice);

        // 最大交易额，需大于最小交易额
        if (maxTrade.compareTo(minTrade) <= 0) {
            throw new BizException("xn000000","单笔最大交易额需大于等于单笔最小交易额");
        }

        if(totalAmount.compareTo(maxTrade) < 0) {
            throw new BizException("xn000000","最大交易额需小于交易总额");
        }

        adsSell.setMaxTrade(maxTrade);
        adsSell.setMinTrade(minTrade);
        adsSell.setPayType(payType);
        adsSell.setPayLimit(payLimit);
        adsSell.setLeaveMessage(leaveMessage);

        return null;

    }
}
