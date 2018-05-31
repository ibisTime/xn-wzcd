package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632132Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 抵押确认提交银行
 * @author: CYL 
 * @since: 2018年5月31日 上午3:35:03 
 * @history:
 */
public class XN632132 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632132Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        budgetOrderAO.mortgageCommitBank(req.getCode(), req.getOperator(),
            req.getPledgeBankCommitDatetime(), req.getPledgeBankCommitNote());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632132Req.class);
        ObjValidater.validateReq(req);
    }

}
