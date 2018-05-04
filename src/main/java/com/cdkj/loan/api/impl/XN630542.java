package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.ao.IRepayPlanAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.dto.req.XN630542Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

public class XN630542 extends AProcessor {

    private IRepayPlanAO repayPlanAO = SpringContextHolder
        .getBean(IRepayPlanAO.class);

    private XN630542Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        RepayPlan condition = new RepayPlan();
        condition.setUserId(req.getUserId());
        condition.setRefType(req.getRefType());
        condition.setRefCode(req.getRefCode());
        condition.setStatus(req.getStatus());
        condition.setOverdueHandler(req.getOverdueHandler());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IRepayBizAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());

        return repayPlanAO.queryRepayPlanList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630542Req.class);
    }
}
