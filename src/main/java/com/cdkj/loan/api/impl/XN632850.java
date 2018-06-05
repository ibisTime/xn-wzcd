package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IEmployApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632850Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 申请应聘
 * @author: xieyj 
 * @since: 2018年6月5日 上午10:15:25 
 * @history:
 */
public class XN632850 extends AProcessor {
    private IEmployApplyAO employApplyAO = SpringContextHolder
        .getBean(IEmployApplyAO.class);

    private XN632850Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        String code = employApplyAO.addEmployApply(req);
        return new PKCodeRes(code);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632850Req.class);
        ObjValidater.validateReq(req);
    }

}
