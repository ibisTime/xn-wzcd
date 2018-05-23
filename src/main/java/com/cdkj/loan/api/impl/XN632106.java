package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IReqBudgetAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632106Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

public class XN632106 extends AProcessor {
    private IReqBudgetAO reqBudgetAO = SpringContextHolder
        .getBean(IReqBudgetAO.class);

    private XN632106Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return reqBudgetAO.getReqBudget(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632106Req.class);
        ObjValidater.validateReq(req);
    }

}
