package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ILogisticsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632152Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 收件待补发
 * @author: silver 
 * @since: 2018年5月30日 下午4:08:33 
 * @history:
 */
public class XN632152 extends AProcessor {
    private ILogisticsAO logisticsAO = SpringContextHolder
        .getBean(ILogisticsAO.class);

    private XN632152Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        logisticsAO.sendAgainLogistics(req.getCode(), req.getOperater(),
            req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632152Req.class);
        ObjValidater.validateReq(req);
    }

}
