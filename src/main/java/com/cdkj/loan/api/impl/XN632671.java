package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IFeeAdvanceApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632671Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 审核费用垫资
 * @author: xieyj 
 * @since: 2018年6月6日 下午10:30:40 
 * @history:
 */
public class XN632671 extends AProcessor {
    private IFeeAdvanceApplyAO feeAdvanceApplyAO = SpringContextHolder
        .getBean(IFeeAdvanceApplyAO.class);

    private XN632671Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        feeAdvanceApplyAO.approveApply(req.getCode(), req.getApproveResult(),
            req.getUpdater(), req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632671Req.class);
        ObjValidater.validateReq(req);
    }

}
