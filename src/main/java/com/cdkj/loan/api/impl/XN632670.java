package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IFeeAdvanceApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632670Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 费用预支申请
 * @author: xieyj 
 * @since: 2018年6月6日 下午9:00:04 
 * @history:
 */
public class XN632670 extends AProcessor {
    private IFeeAdvanceApplyAO feeAdvanceApplyAO = SpringContextHolder
        .getBean(IFeeAdvanceApplyAO.class);

    private XN632670Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        String code = feeAdvanceApplyAO.addFeeAdvanceApply(req);
        return new PKCodeRes(code);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632670Req.class);
        ObjValidater.validateReq(req);
    }

}
