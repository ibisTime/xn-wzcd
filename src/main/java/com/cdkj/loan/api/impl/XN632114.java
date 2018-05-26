package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632114Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 征信一审
 * @author: jiafr 
 * @since: 2018年5月26日 下午9:51:47 
 * @history:
 */
public class XN632114 extends AProcessor {
    private ICreditAO creditAO = SpringContextHolder.getBean(ICreditAO.class);

    private XN632114Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        creditAO.firstAudit(req);

        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632114Req.class);
        ObjValidater.validateReq(req);

    }

}
