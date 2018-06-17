package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630573Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 申请解除
 * @author: silver 
 * @since: 2018年6月17日 下午6:39:22 
 * @history:
 */
public class XN630573 extends AProcessor {
    private IRepayBizAO repayBizAO = SpringContextHolder
        .getBean(IRepayBizAO.class);

    private XN630573Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        repayBizAO.settleReleaseMortgageApply(req.getCode(),
            req.getReleaseApplyNote(), req.getOperator());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630573Req.class);
        ObjValidater.validateReq(req);
    }

}
