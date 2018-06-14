package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.dto.req.XN632132Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

public class XN632132 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632132Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BudgetOrder condition = new BudgetOrder();
        condition.setCompanyCode(req.getCompanyCode());
        condition.setCarDealerCode(req.getCarDealerCode());
        condition.setStatus(req.getStatus());
        condition.setLoanBankCode(req.getLoanBankCode());
        condition.setIsAdvanceFund(req.getIsAdvanceFund());
        condition.setApplyDatetimeStart(req.getApplyDatetimeStart());
        condition.setApplyDatetimeEnd(req.getApplyDatetimeEnd());
        return budgetOrderAO.queryBudgetOrderList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632132Req.class);
        ObjValidater.validateReq(req);
    }

}
