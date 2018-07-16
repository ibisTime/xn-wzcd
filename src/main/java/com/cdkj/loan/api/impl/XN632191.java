package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632191Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 车辆抵押确认抵押完成
 * @author: jiafr 
 * @since: 2018年7月14日 下午5:44:59 
 * @history:
 */
public class XN632191 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632191Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        budgetOrderAO.carPledgeConfirm(req.getCode(), req.getOperator(),
            req.getGreenBigSmj());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632191Req.class);
        ObjValidater.validateReq(req);
    }

}
