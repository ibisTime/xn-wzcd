package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBankSubbranchAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632052Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改支行
 * @author: silver 
 * @since: 2018年5月28日 上午11:02:47 
 * @history:
 */
public class XN632052 extends AProcessor {

    private IBankSubbranchAO bankSubbranchAO = SpringContextHolder
        .getBean(IBankSubbranchAO.class);

    private XN632052Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        bankSubbranchAO.editBankSubbranch(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632052Req.class);
        ObjValidater.validateReq(req);
    }
}
