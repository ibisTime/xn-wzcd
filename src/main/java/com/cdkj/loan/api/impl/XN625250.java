/**
 * @Title XN625240.java 
 * @Package com.cdkj.coin.api.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年11月14日 下午12:40:28 
 * @version V1.0   
 */
package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ITradeOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.TradeOrder;
import com.cdkj.loan.dto.req.XN625250Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 分页查询交易订单
 * @author: haiqingzheng 
 * @since: 2017年11月14日 下午12:40:28 
 * @history:
 */
public class XN625250 extends AProcessor {

    private ITradeOrderAO tradeOrderAO = SpringContextHolder
        .getBean(ITradeOrderAO.class);

    private XN625250Req req;

    /** 
     * @see com.cdkj.loan.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        TradeOrder condition = new TradeOrder();
        condition.setCodeForQuery(req.getCode());
        condition.setType(req.getType());
        condition.setAdsCode(req.getAdsCode());
        condition.setBuyUser(req.getBuyUser());
        condition.setSellUser(req.getSellUser());
        condition.setTradeCurrency(req.getTradeCurrency());
        condition.setPayType(req.getPayType());
        if (req.getStatusList() != null && !req.getStatusList().isEmpty()) {

            condition.setStatusList(req.getStatusList());

        }
        condition.setStatus(req.getStatus());
        condition.setBelongUser(req.getBelongUser());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return tradeOrderAO.queryTradeOrderPage(start, limit, condition);
    }

    /** 
     * @see com.cdkj.loan.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN625250Req.class);
        ObjValidater.validateReq(req);
    }

}
