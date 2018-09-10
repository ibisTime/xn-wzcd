package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632124Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 准入审核二审（预算单准入流程最后一步）
 * @author: jiafr 
 * @since: 2018年7月15日 下午8:49:31 
 * @history:
 */
public class XN632124 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632124Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        budgetOrderAO.approveGlobalManager(req.getCode(), req.getOperator(),
            req.getApproveResult(), req.getApproveNote(), req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632124Req.class);
        ObjValidater.validateReq(req);
    }

}
