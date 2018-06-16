package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IReplaceRepayPlanAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632331Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 风控经理审核
 * @author: silver 
 * @since: 2018年6月16日 上午10:03:21 
 * @history:
 */
public class XN632331 extends AProcessor {
    private IReplaceRepayPlanAO replaceRepayPlanAO = SpringContextHolder
        .getBean(IReplaceRepayPlanAO.class);

    private XN632331Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        replaceRepayPlanAO.approveByRiskManage(req.getCode(),
            req.getApproveResult(), req.getRiskNote(), req.getRemark(),
            req.getOperator());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632331Req.class);
        ObjValidater.validateReq(req);
    }

}
