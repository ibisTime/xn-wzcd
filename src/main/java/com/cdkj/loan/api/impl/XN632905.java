package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IPerformanceBondAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.PerformanceBond;
import com.cdkj.loan.dto.req.XN632905Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详细查询请假申请
 * @author: silver 
 * @since: 2018年6月5日 下午9:06:31 
 * @history:
 */
public class XN632905 extends AProcessor {
    private IPerformanceBondAO performanceBondAO = SpringContextHolder
        .getBean(IPerformanceBondAO.class);

    private XN632905Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        PerformanceBond condition = new PerformanceBond();
        condition.setBudgetCode(req.getBudgetCode());
        condition.setLoanBankCode(req.getLoanBankCode());
        condition.setCustomerName(req.getCustomerName());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IPerformanceBondAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return performanceBondAO.queryPerformanceBondPage(start, limit,
            condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632905Req.class);
        ObjValidater.validateReq(req);
    }
}
