package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IFeeAdvanceApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632676Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 费用提前申请详情查询
 * @author: xieyj 
 * @since: 2018年6月6日 下午10:34:02 
 * @history:
 */
public class XN632676 extends AProcessor {
    private IFeeAdvanceApplyAO feeAdvanceApplyAO = SpringContextHolder
        .getBean(IFeeAdvanceApplyAO.class);

    private XN632676Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return feeAdvanceApplyAO.getFeeAdvanceApply(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632676Req.class);
        ObjValidater.validateReq(req);
    }

}
