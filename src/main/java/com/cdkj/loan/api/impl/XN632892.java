package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ILeaveApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632892Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 获取休假时间
 * @author: silver 
 * @since: 2018年6月6日 下午10:51:58 
 * @history:
 */
public class XN632892 extends AProcessor {

    private ILeaveApplyAO leaveApplyAO = SpringContextHolder
        .getBean(ILeaveApplyAO.class);

    private XN632892Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return leaveApplyAO.getLeavedHour(req.getApplyUser());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632892Req.class);
        ObjValidater.validateReq(req);
    }
}
