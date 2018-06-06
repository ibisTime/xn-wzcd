package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarBreakAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632631Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 违章处理审核
 * @author: silver 
 * @since: 2018年6月6日 下午4:59:32 
 * @history:
 */
public class XN632631 extends AProcessor {
    private ICarBreakAO carBreakAO = SpringContextHolder
        .getBean(ICarBreakAO.class);

    private XN632631Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        carBreakAO.approveCarBreak(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632631Req.class);
        ObjValidater.validateReq(req);
    }
}
