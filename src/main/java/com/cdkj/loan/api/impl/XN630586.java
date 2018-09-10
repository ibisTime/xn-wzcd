package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630586Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 解除抵押:风控总监审核
 * @author: CYL 
 * @since: 2018年8月28日 下午5:28:46 
 * @history:
 */
public class XN630586 extends AProcessor {
    private IRepayBizAO repayBizAO = SpringContextHolder
        .getBean(IRepayBizAO.class);

    private XN630586Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        repayBizAO.settleriskManageAudit(req.getCode(), req.getApproveResult(),
            req.getApplyNote(), req.getOperator(), req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630586Req.class);
        ObjValidater.validateReq(req);
    }

}
