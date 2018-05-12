package com.cdkj.loan.api.impl;

import java.math.BigDecimal;

import com.cdkj.loan.ao.IChargeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN802700Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 线下充值申请
 * @author: myb858 
 * @since: 2017年5月3日 上午9:23:51 
 * @history:
 */
public class XN802700 extends AProcessor {
    private IChargeAO chargeAO = SpringContextHolder.getBean(IChargeAO.class);

    private XN802700Req req = null;

    /** 
    * @see com.xnjr.base.api.IProcessor#doBusiness()
    */
    @Override
    public synchronized Object doBusiness() throws BizException {
        BigDecimal amount = StringValidater.toBigDecimal(req.getAmount());
        String code = chargeAO.applyOrder(req.getAccountNumber(), amount,
            req.getPayCardInfo(), req.getPayCardNo(), req.getApplyUser(),
            req.getApplyNote());
        return new PKCodeRes(code);
    }

    /** 
    * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
    */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802700Req.class);
        ObjValidater.validateReq(req);
    }
}
