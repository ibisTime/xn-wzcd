package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISuppleSignApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632601Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 补签审核
 * @author: silver 
 * @since: 2018年6月6日 下午12:07:33 
 * @history:
 */
public class XN632601 extends AProcessor {
    private ISuppleSignApplyAO suppleSignApplyAO = SpringContextHolder
        .getBean(ISuppleSignApplyAO.class);

    private XN632601Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        suppleSignApplyAO.approveSuppleSignApply(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632601Req.class);
        ObjValidater.validateReq(req);
    }
}
