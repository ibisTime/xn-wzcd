package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IReplaceRepayApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632321Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 代偿预算单财务审核
 * @author: silver 
 * @since: 2018年6月15日 上午10:49:55 
 * @history:
 */
public class XN632321 extends AProcessor {

    private IReplaceRepayApplyAO replaceRepayApplyAO = SpringContextHolder
        .getBean(IReplaceRepayApplyAO.class);

    private XN632321Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        replaceRepayApplyAO.refreshFinanceManageApprove(req.getCode(),
            req.getApproveResult(), req.getOperator(), req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632321Req.class);
        ObjValidater.validateReq(req);
    }
}
