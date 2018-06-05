package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ILeaveApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632891Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 审核请假申请
 * @author: silver 
 * @since: 2018年6月5日 下午8:33:35 
 * @history:
 */
public class XN632891 extends AProcessor {

    private ILeaveApplyAO leaveApplyOutAO = SpringContextHolder
        .getBean(ILeaveApplyAO.class);

    private XN632891Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        leaveApplyOutAO.approveLeaveApply(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632891Req.class);
        ObjValidater.validateReq(req);
    }
}
