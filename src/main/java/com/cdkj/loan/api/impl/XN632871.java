package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IConvertApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632871Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 审核
 * @author: CYL 
 * @since: 2018年6月5日 下午9:50:31 
 * @history:
 */
public class XN632871 extends AProcessor {
    private IConvertApplyAO convertApplyAO = SpringContextHolder
        .getBean(IConvertApplyAO.class);

    private XN632871Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        convertApplyAO.approveConvertApply(req.getCode(),
            req.getApproveResult(), req.getUpdater(), req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632871Req.class);
        ObjValidater.validateReq(req);
    }

}
