package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayPlanAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.dto.req.XN630540Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询还款计划
 * @author: haiqingzheng 
 * @since: 2018年5月6日 下午5:47:08 
 * @history:
 */
public class XN630540 extends AProcessor {

    private IRepayPlanAO repayPlanAO = SpringContextHolder
        .getBean(IRepayPlanAO.class);

    private XN630540Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        RepayPlan condition = new RepayPlan();
        condition.setUserId(req.getUserId());
        condition.setRepayBizCode(req.getRepayBizCode());
        condition.setCurNodeCode(req.getCurNodeCode());
        condition.setCurNodeCodeList(req.getCurNodeCodeList());
        condition.setOverdueHandler(req.getOverdueHandler());

        condition.setOrder("cur_periods", true);
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return repayPlanAO.queryRepayPlanPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630540Req.class);
        ObjValidater.validateReq(req);
    }
}
