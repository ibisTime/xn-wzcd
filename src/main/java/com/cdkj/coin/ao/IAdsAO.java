package com.cdkj.coin.ao;

import com.cdkj.coin.dto.req.XN625220Req;
import org.omg.CORBA.Object;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public interface IAdsAO {

     public Object insertAds(String userId, String tradeCurrency, String tradeCoin, String onlyTrust, BigDecimal premiumRate, BigDecimal totalAmount, BigDecimal leftAmount, BigDecimal protectPrice, BigDecimal minTrade, BigDecimal maxTrade, String payType, Integer payLimit,  String leaveMessage);


}
