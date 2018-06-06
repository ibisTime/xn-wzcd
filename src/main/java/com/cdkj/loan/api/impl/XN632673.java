package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IFeeAdvanceApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632673Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 确认放款
 * @author: xieyj 
 * @since: 2018年6月6日 下午10:30:40 
 * @history:
 */
public class XN632673 extends AProcessor {
    private IFeeAdvanceApplyAO feeAdvanceApplyAO = SpringContextHolder
        .getBean(IFeeAdvanceApplyAO.class);

    private XN632673Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        feeAdvanceApplyAO.sureFk(req.getCode(), req.getPayDatetime(),
            req.getPayBank(), req.getPayBankcard(), req.getPayPdf(),
            req.getUpdater());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632673Req.class);
        ObjValidater.validateReq(req);
    }

}
