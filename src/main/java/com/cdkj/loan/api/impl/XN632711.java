package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IGpsApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632711Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * GPS申领审核通过
 * @author: silver 
 * @since: 2018年5月31日 上午12:39:53 
 * @history:
 */
public class XN632711 extends AProcessor {
    private IGpsApplyAO gpsApplyAO = SpringContextHolder
        .getBean(IGpsApplyAO.class);

    private XN632711Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        gpsApplyAO.approveYesGpsApply(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632711Req.class);
        ObjValidater.validateReq(req);
    }
}
