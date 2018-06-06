package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAskForApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632650Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 领导请示申请
 * @author: CYL 
 * @since: 2018年6月6日 下午5:45:49 
 * @history:
 */
public class XN632650 extends AProcessor {
    private IAskForApplyAO askForApplyAO = SpringContextHolder
        .getBean(IAskForApplyAO.class);

    private XN632650Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(askForApplyAO.addAskForApply(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632650Req.class);
        ObjValidater.validateReq(req);
    }

}
