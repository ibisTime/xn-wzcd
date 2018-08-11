package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBankRepointAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632313Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 退回银行返佣的佣金
 * @author: jiafr 
 * @since: 2018年8月11日 下午2:18:03 
 * @history:
 */
public class XN632313 extends AProcessor {

    private IBankRepointAO bankRepointAO = SpringContextHolder
        .getBean(IBankRepointAO.class);

    private XN632313Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        bankRepointAO.sendBackBankRepoint(req.getCode(),
            req.getSendBackAmount(), req.getBillPdf(), req.getOperator());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632313Req.class);
        ObjValidater.validateReq(req);
    }
}
