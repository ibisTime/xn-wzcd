package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ILeaveApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632896Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详细查询请假申请
 * @author: silver 
 * @since: 2018年6月5日 下午9:06:31 
 * @history:
 */
public class XN632896 extends AProcessor {
    private ILeaveApplyAO leaveApplyOutAO = SpringContextHolder
        .getBean(ILeaveApplyAO.class);

    private XN632896Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return leaveApplyOutAO.getLeaveApply(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632896Req.class);
        ObjValidater.validateReq(req);
    }
}
