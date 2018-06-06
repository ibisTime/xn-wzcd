package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarBreakAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632630Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 违章处理
 * @author: silver 
 * @since: 2018年6月6日 下午4:48:50 
 * @history:
 */
public class XN632630 extends AProcessor {

    private ICarBreakAO carBreakAO = SpringContextHolder
        .getBean(ICarBreakAO.class);

    private XN632630Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(carBreakAO.addCarBreak(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632630Req.class);
        ObjValidater.validateReq(req);
    }
}
