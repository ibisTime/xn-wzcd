package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBankSubbranchAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632056Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详细查询支行
 * @author: silver 
 * @since: 2018年5月28日 上午11:21:50 
 * @history:
 */
public class XN632056 extends AProcessor {

    private IBankSubbranchAO bankSubbranchAO = SpringContextHolder
        .getBean(IBankSubbranchAO.class);

    private XN632056Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return bankSubbranchAO.getBankSubbranch(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632056Req.class);
        ObjValidater.validateReq(req);
    }
}
