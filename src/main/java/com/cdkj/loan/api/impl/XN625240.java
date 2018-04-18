/**
 * @Title XN625240.java 
 * @Package com.cdkj.coin.api.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年11月14日 下午12:40:28 
 * @version V1.0   
 */
package com.cdkj.loan.api.impl;

import java.math.BigDecimal;

import com.cdkj.loan.ao.IAdsAO;
import com.cdkj.loan.ao.ITradeOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.TradeOrder;
import com.cdkj.loan.dto.req.XN625240Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 我要购买
 * @author: haiqingzheng 
 * @since: 2017年11月14日 下午12:40:28 
 * @history:
 */
public class XN625240 extends AProcessor {

    private ITradeOrderAO tradeOrderAO = SpringContextHolder
        .getBean(ITradeOrderAO.class);

    private IAdsAO adsAO = SpringContextHolder.getBean(IAdsAO.class);

    private XN625240Req req;

    /** 
     * @see com.cdkj.loan.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        BigDecimal tradePrice = StringValidater.toBigDecimal(req
            .getTradePrice());
        BigDecimal count = StringValidater.toBigDecimal(req.getCount());
        BigDecimal tradeAmount = StringValidater.toBigDecimal(req
            .getTradeAmount());
        TradeOrder tradeOrder = tradeOrderAO.buy(req.getAdsCode(),
            req.getBuyUser(), tradePrice, count, tradeAmount);
        // 检查 是否可以下架
        adsAO.checkXiajia(tradeOrder.getAdsCode());
        return new PKCodeRes(tradeOrder.getCode());
    }

    /** 
     * @see com.cdkj.loan.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN625240Req.class);
        req.setBuyUser(operator);
        ObjValidater.validateReq(req);
    }

}
