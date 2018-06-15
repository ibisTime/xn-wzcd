package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.dto.req.XN632197Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 银行放款列表查
 * @author: silver 
 * @since: 2018年6月13日 下午3:04:03 
 * @history:
 */
public class XN632197 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632197Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BudgetOrder condition = new BudgetOrder();
        condition.setCode(req.getCode());
        condition.setCustomerName(req.getCustomerName());
        condition.setLoanBankCode(req.getLoanBankCode());
        // condition.setCurNodeCode(EBudgetOrderNode.AREA_AUDIT.getCode());

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IBudgetOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        return budgetOrderAO.queryBudgetOrderList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632197Req.class);
        ObjValidater.validateReq(req);
    }
}
