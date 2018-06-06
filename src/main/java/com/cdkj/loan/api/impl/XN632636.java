package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarBreakAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632636Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详细查询违章
 * @author: silver 
 * @since: 2018年6月6日 下午5:06:07 
 * @history:
 */
public class XN632636 extends AProcessor {
    private ICarBreakAO carBreakAO = SpringContextHolder
        .getBean(ICarBreakAO.class);

    private XN632636Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return carBreakAO.getCarBreak(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632636Req.class);
        ObjValidater.validateReq(req);
    }
}
