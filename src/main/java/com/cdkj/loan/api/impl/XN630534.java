package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayPlanAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630534Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 缴纳代偿金额
 * @author: CYL 
 * @since: 2018年6月11日 下午7:46:19 
 * @history:
 */
public class XN630534 extends AProcessor {
    private IRepayPlanAO repayPlanAO = SpringContextHolder
        .getBean(IRepayPlanAO.class);

    private XN630534Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        repayPlanAO.repayAmount(req.getCode(), req.getOperator(),
            req.getPayType());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630534Req.class);
        ObjValidater.validateReq(req);
    }

}
