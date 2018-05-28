package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBankSubbranchAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.BankSubbranch;
import com.cdkj.loan.dto.req.XN632057Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询支行
 * @author: silver 
 * @since: 2018年5月28日 上午11:24:11 
 * @history:
 */
public class XN632057 extends AProcessor {

    private IBankSubbranchAO bankSubbranchAO = SpringContextHolder
        .getBean(IBankSubbranchAO.class);

    private XN632057Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BankSubbranch condition = new BankSubbranch();
        condition.setBankCode(req.getBankCode());
        return bankSubbranchAO.queryBankSubbranchList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632057Req.class);
        ObjValidater.validateReq(req);
    }

}
