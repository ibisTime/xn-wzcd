/**
 * @Title XN625240.java 
 * @Package com.cdkj.coin.api.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年11月14日 下午12:40:28 
 * @version V1.0   
 */
package com.cdkj.coin.api.impl;

import java.math.BigDecimal;

import com.cdkj.coin.ao.IAdsAO;
import com.cdkj.coin.ao.ITradeOrderAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.ObjValidater;
import com.cdkj.coin.core.StringValidater;
import com.cdkj.coin.domain.TradeOrder;
import com.cdkj.coin.dto.req.XN625241Req;
import com.cdkj.coin.dto.res.PKCodeRes;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/** 
 * 我要出售
 * @author: haiqingzheng 
 * @since: 2017年11月14日 下午12:40:28 
 * @history:
 */
public class XN625241 extends AProcessor {

    private ITradeOrderAO tradeOrderAO = SpringContextHolder
        .getBean(ITradeOrderAO.class);

    private IAdsAO adsAO = SpringContextHolder.getBean(IAdsAO.class);

    private XN625241Req req;

    /** 
     * @see com.cdkj.coin.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        BigDecimal tradePrice = StringValidater.toBigDecimal(req
            .getTradePrice());
        BigDecimal count = StringValidater.toBigDecimal(req.getCount());
        BigDecimal tradeAmount = StringValidater.toBigDecimal(req
            .getTradeAmount());
        TradeOrder tradeOrder = tradeOrderAO.sell(req.getAdsCode(),
            req.getSellUser(), tradePrice, count, tradeAmount);
        // 检查 是否可以下架
        adsAO.checkXiajia(tradeOrder.getAdsCode());
        return new PKCodeRes(tradeOrder.getCode());
    }

    /** 
     * @see com.cdkj.coin.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN625241Req.class);
        req.setSellUser(operator);
        ObjValidater.validateReq(req);
    }

}
