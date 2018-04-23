package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630431Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 处理
 * @author: CYL 
 * @since: 2018年4月23日 上午9:50:53 
 * @history:
 */

public class XN630431 extends AProcessor {

    private ICarOrderAO carOrderAO = SpringContextHolder
        .getBean(ICarOrderAO.class);

    private XN630431Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        carOrderAO.editCarOrder(req.getCode(), req.getHandler(),
            req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630431Req.class);
        ObjValidater.validateReq(req);

    }

}
