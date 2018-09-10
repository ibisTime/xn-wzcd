package com.cdkj.loan.api.impl;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.dto.req.XN632148Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 预算单按角色分页查询
 * @author: CYL 
 * @since: 2018年5月24日 下午2:23:15 
 * @history:
 */
public class XN632148 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632148Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BudgetOrder condition = new BudgetOrder();
        condition.setCode(req.getCode());
        condition.setSaleUserId(req.getSaleUserId());
        condition.setCustomerName(req.getCustomerName());
        condition.setApplyDatetimeStart(DateUtil.strToDate(
            req.getApplyDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        if (StringUtils.isNotBlank(req.getApplyDatetimeEnd())) {
            // 申请时间止加一
            Calendar calendar = Calendar.getInstance();
            Date date = DateUtil.strToDate(req.getApplyDatetimeEnd(),
                DateUtil.FRONT_DATE_FORMAT_STRING);
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, +1);
            Date time = calendar.getTime();
            condition.setApplyDatetimeEnd(time);
        }
        condition.setCurNodeCode(req.getCurNodeCode());
        condition.setCarDealerCode(req.getCarDealerCode());
        condition.setLoanBankCode(req.getLoanBankCode());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setRoleCode(req.getRoleCode());
        condition.setIsAdvanceFund(req.getIsAdvanceFund());
        condition.setCurNodeCodeList(req.getCurNodeCodeList());
        condition.setPledgeCurNodeCodeList(req.getPledgeCurNodeCodeList());
        condition.setEnterFileStatusList(req.getEnterFileStatusList());
        condition.setCurrentUserCompanyCode(req.getCurrentUserCompanyCode());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBudgetOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return budgetOrderAO.queryBudgetOrderPageByRoleCode(start, limit,
            condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632148Req.class);
        ObjValidater.validateReq(req);
    }

}
