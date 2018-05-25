package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.dto.req.XN632110Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

public class XN632110 extends AProcessor {

    private ICreditAO iCreditAO = SpringContextHolder.getBean(ICreditAO.class);

    private XN632110Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        Credit data = new Credit();

        return null;
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632110Req.class);
        ObjValidater.validateReq(req);

    }

}
