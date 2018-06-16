package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBankSubbranchAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632051Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 删除支行
 * @author: silver 
 * @since: 2018年5月28日 上午11:02:47 
 * @history:
 */
public class XN632051 extends AProcessor {

    private IBankSubbranchAO bankSubbranchAO = SpringContextHolder
        .getBean(IBankSubbranchAO.class);

    private XN632051Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        bankSubbranchAO.dropBankSubbranch(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632051Req.class);
        ObjValidater.validateReq(req);
    }
}
