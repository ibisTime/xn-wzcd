package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632260Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 应退按揭款确认放款
 * @author: jiafr 
 * @since: 2018年7月16日 上午10:30:21 
 * @history:
 */
public class XN632260 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632260Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        budgetOrderAO.mortgageRefund(req.getCode(),
            req.getShouldBackBankcardCode(), req.getShouldBackDatetime(),
            req.getShouldBackBillPdf());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632260Req.class);
        ObjValidater.validateReq(req);
    }

}
