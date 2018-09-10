package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630552Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 收车分公司总经理审核
 * @author: xieyj 
 * @since: 2018年6月17日 下午2:49:50 
 * @history:
 */
public class XN630552 extends AProcessor {
    private IRepayBizAO repayBizAO = SpringContextHolder
        .getBean(IRepayBizAO.class);

    private XN630552Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        repayBizAO.takeCarCompanyManageCheck(req.getCode(),
            req.getApproveResult(), req.getApproveNote(), req.getOperator(),
            req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630552Req.class);
        ObjValidater.validateReq(req);
    }

}
