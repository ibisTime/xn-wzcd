package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.dto.req.XN632135Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

public class XN632130 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632135Req req = null;

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
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBudgetOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return budgetOrderAO.queryBudgetOrderPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632135Req.class);
        ObjValidater.validateReq(req);
    }

}
