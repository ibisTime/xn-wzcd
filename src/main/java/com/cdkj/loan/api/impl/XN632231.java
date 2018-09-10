package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632231Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 发票不匹配审核
 * @author: jiafr 
 * @since: 2018年6月30日 下午8:00:45 
 * @history:
 */
public class XN632231 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632231Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        budgetOrderAO.invoiceMismatchApprove(req.getCode(),
            req.getApproveResult(), req.getApproveNote(), req.getRemark(),
            req.getOperator());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632231Req.class);
        ObjValidater.validateReq(req);
    }

}
