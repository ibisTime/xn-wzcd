package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ITravelApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632620Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增出差/公出申请
 * @author: jiafr 
 * @since: 2018年6月6日 下午12:50:39 
 * @history:
 */
public class XN632620 extends AProcessor {
    private ITravelApplyAO travelApplyAO = SpringContextHolder
        .getBean(ITravelApplyAO.class);

    private XN632620Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(travelApplyAO.addTravelApply(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632620Req.class);
        ObjValidater.validateReq(req);
    }

}
