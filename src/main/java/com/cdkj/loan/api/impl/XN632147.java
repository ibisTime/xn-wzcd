package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.dto.req.XN632147Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 预算单列表查
 * @author: CYL 
 * @since: 2018年6月14日 下午11:41:53 
 * @history:
 */
public class XN632147 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632147Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BudgetOrder condition = new BudgetOrder();
        condition.setCode(req.getCode());
        condition.setCustomerName(req.getCustomerName());
        condition.setApplyDatetimeStart(DateUtil.strToDate(
            req.getApplyDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setApplyDatetimeEnd(DateUtil.strToDate(
            req.getApplyDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setCurNodeCode(req.getCurNodeCode());
        condition.setCarDealerCode(req.getCarDealerCode());
        condition.setLoanBankCode(req.getLoanBankCode());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setIsAdvanceFund(req.getIsAdvanceFund());

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
        req = JsonUtil.json2Bean(inputparams, XN632147Req.class);
        ObjValidater.validateReq(req);
    }
}
