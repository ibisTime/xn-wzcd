package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630574Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 风控内勤审核
 * @author: silver 
 * @since: 2018年6月17日 下午6:39:22 
 * @history:
 */
public class XN630574 extends AProcessor {
    private IRepayBizAO repayBizAO = SpringContextHolder
        .getBean(IRepayBizAO.class);

    private XN630574Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        repayBizAO.settleRiskIndoorCheck(req.getCode(), req.getApproveResult(),
            req.getApplyNote(), req.getOperator());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630574Req.class);
        ObjValidater.validateReq(req);
    }

}
