package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISuppleSignApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632600Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 补签
 * @author: silver 
 * @since: 2018年6月6日 上午11:46:24 
 * @history:
 */
public class XN632600 extends AProcessor {

    private ISuppleSignApplyAO suppleSignApplyAO = SpringContextHolder
        .getBean(ISuppleSignApplyAO.class);

    private XN632600Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(suppleSignApplyAO.addSuppleSignApply(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632600Req.class);
        ObjValidater.validateReq(req);
    }
}
