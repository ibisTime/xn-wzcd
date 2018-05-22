package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISYSRoleNodeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630160Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

public class XN630160 extends AProcessor {

    private ISYSRoleNodeAO sysRoleNode = SpringContextHolder
        .getBean(ISYSRoleNodeAO.class);

    private XN630160Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {

        req = JsonUtil.json2Bean(inputparams, XN630160Req.class);
        ObjValidater.validateReq(req);

    }

}
