package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderGpsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632343Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * gps 回收作废
 * @author: silver 
 * @since: 2018年6月18日 下午5:40:54 
 * @history:
 */
public class XN632343 extends AProcessor {
    private IBudgetOrderGpsAO budgetOrderGpsAO = SpringContextHolder
        .getBean(IBudgetOrderGpsAO.class);

    private XN632343Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        budgetOrderGpsAO.abandonBudgetOrderGps(req.getCode(), req.getRemark(),
            req.getOperator());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632343Req.class);
        ObjValidater.validateReq(req);
    }

}
