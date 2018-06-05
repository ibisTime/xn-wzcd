package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IEmployApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632851Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 面试
 * @author: xieyj 
 * @since: 2018年6月5日 上午10:15:25 
 * @history:
 */
public class XN632851 extends AProcessor {
    private IEmployApplyAO employApplyAO = SpringContextHolder
        .getBean(IEmployApplyAO.class);

    private XN632851Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        employApplyAO.interviewEmployApply(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632851Req.class);
        ObjValidater.validateReq(req);
    }

}
