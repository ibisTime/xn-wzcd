package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISuppleSignApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632606Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详细查询补签
 * @author: silver 
 * @since: 2018年6月6日 下午12:35:42 
 * @history:
 */
public class XN632606 extends AProcessor {
    private ISuppleSignApplyAO suppleSignApplyAO = SpringContextHolder
        .getBean(ISuppleSignApplyAO.class);

    private XN632606Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return suppleSignApplyAO.getSuppleSignApply(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632606Req.class);
        ObjValidater.validateReq(req);
    }
}
