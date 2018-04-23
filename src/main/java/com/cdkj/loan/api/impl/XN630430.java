package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630430Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 申请
 * @author: CYL 
 * @since: 2018年4月23日 下午4:26:43 
 * @history:
 */

public class XN630430 extends AProcessor {

    private ICarOrderAO carOrderAO = SpringContextHolder
        .getBean(ICarOrderAO.class);

    private XN630430Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(carOrderAO.addCarOrder(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630430Req.class);
        ObjValidater.validateReq(req);
    }

}
