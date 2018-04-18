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
import com.cdkj.loan.dto.req.XN625243Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 买家标记打款
 * @author: haiqingzheng 
 * @since: 2017年11月14日 下午12:40:28 
 * @history:
 */
public class XN625243 extends AProcessor {

    private ITradeOrderAO tradeOrderAO = SpringContextHolder
        .getBean(ITradeOrderAO.class);

    private XN625243Req req;

    /** 
     * @see com.cdkj.loan.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        tradeOrderAO.markPay(req.getCode(), req.getUpdater(), req.getRemark());
        return new BooleanRes(true);
    }

    /** 
     * @see com.cdkj.loan.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN625243Req.class);
        req.setUpdater(operator);
        ObjValidater.validateReq(req);
    }

}
