package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ITravelApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632626Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 角色-详情
 * @author: xieyj 
 * @since: 2016年4月17日 上午8:26:30 
 * @history:
 */
public class XN632626 extends AProcessor {
    private ITravelApplyAO travelApplyAO = SpringContextHolder
        .getBean(ITravelApplyAO.class);

    private XN632626Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return travelApplyAO.getTravelApply(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632626Req.class);
        ObjValidater.validateReq(req);
    }
}
