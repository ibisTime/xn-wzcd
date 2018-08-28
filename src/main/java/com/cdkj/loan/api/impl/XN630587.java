package com.cdkj.loan.api.impl;

import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.dto.req.XN630587Req;
import com.cdkj.loan.enums.EBudgetOrderNode;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 是否经过车辆抵押
 * @author: CYL 
 * @since: 2018年8月28日 下午5:28:46 
 * @history:
 */
public class XN630587 extends AProcessor {
    private IBudgetOrderBO budgetOrderBO = SpringContextHolder
        .getBean(IBudgetOrderBO.class);

    private XN630587Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Boolean b = null;
        BudgetOrder budgetOrder = budgetOrderBO
            .getBudgetOrderByRepayBizCode(req.getCode());
        if (EBudgetOrderNode.LOCAL_PLEDGE_ACHIEVE.getCode()
            .equals(budgetOrder.getPledgeCurNodeCode())
                || EBudgetOrderNode.OUT_PLEDGE_ACHIEVE.getCode()
                    .equals(budgetOrder.getPledgeCurNodeCode())) {
            b = true;
        } else {
            b = false;
        }
        return b;
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630587Req.class);
        ObjValidater.validateReq(req);
    }

}
