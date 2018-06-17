package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630553Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 拖车风控总监审核
 * @author: xieyj 
 * @since: 2018年6月17日 下午2:50:49 
 * @history:
 */
public class XN630553 extends AProcessor {
    private IRepayBizAO repayBizAO = SpringContextHolder
        .getBean(IRepayBizAO.class);

    private XN630553Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        repayBizAO.takeCarRiskLeaderCheck(req.getCode(),
            req.getApproveResult(), req.getOperator(), req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630553Req.class);
        ObjValidater.validateReq(req);
    }

}
