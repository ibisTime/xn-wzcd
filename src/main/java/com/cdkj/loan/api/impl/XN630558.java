package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630571Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 财务审核
 * @author: CYL 
 * @since: 2018年8月3日 下午4:38:05 
 * @history:
 */
public class XN630558 extends AProcessor {
    private IRepayBizAO repayBizAO = SpringContextHolder
        .getBean(IRepayBizAO.class);

    private XN630571Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        repayBizAO.financialAudit(req.getCode(), req.getApproveResult(),
            req.getApproveNote(), req.getOperator());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630571Req.class);
        ObjValidater.validateReq(req);
    }

}
