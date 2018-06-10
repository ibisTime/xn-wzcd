package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.dto.req.XN632195Req;
import com.cdkj.loan.enums.EBudgetFrozenStatus;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询客户作废
 * @author: jiafr 
 * @since: 2018年6月10日 下午9:50:05 
 * @history:
 */
public class XN632195 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632195Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BudgetOrder condition = new BudgetOrder();
        condition.setCode(req.getBizCode());
        condition.setApplyUserName(req.getApplyUserName());
        condition.setAdvanceFundDatetimeStart(DateUtil.strToDate(
            req.getAdvanceFundDatetimeStart(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        condition
            .setAdvanceFundDatetimeEnd(DateUtil.strToDate(
                req.getAdvanceFundDatetimeEnd(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setFrozenStatus(EBudgetFrozenStatus.FROZEN.getCode());

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
        req = JsonUtil.json2Bean(inputparams, XN632195Req.class);
        ObjValidater.validateReq(req);
    }

}
