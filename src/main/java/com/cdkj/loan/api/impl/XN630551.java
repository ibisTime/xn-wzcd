package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630551Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 收车分控经理审核
 * @author: xieyj 
 * @since: 2018年6月17日 下午2:47:43 
 * @history:
 */
public class XN630551 extends AProcessor {
    private IRepayBizAO repayBizAO = SpringContextHolder
        .getBean(IRepayBizAO.class);

    private XN630551Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        repayBizAO.takeCarRiskManageCheck(req.getCode(), req.getApproveResult(),
            req.getApproveNote(), req.getOperator(), req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630551Req.class);
        ObjValidater.validateReq(req);
    }

}
