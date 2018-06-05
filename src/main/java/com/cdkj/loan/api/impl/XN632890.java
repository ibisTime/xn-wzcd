package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ILeaveApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632890Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 请假申请
 * @author: silver 
 * @since: 2018年6月5日 下午8:33:35 
 * @history:
 */
public class XN632890 extends AProcessor {

    private ILeaveApplyAO leaveApplyOutAO = SpringContextHolder
        .getBean(ILeaveApplyAO.class);

    private XN632890Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(leaveApplyOutAO.addLeaveApply(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632890Req.class);
        ObjValidater.validateReq(req);
    }
}
