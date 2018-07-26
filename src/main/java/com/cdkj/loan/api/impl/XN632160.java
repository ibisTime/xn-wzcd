package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderFeeDetailAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632160Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 手续费收款回录（手续费明细录入）
 * @author: jiafr 
 * @since: 2018年5月30日 下午8:54:43 
 * @history:
 */
public class XN632160 extends AProcessor {
    private IBudgetOrderFeeDetailAO budgetOrderFeeDetailAO = SpringContextHolder
        .getBean(IBudgetOrderFeeDetailAO.class);

    private XN632160Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(
            budgetOrderFeeDetailAO.addBudgetOrderFeeDetail(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632160Req.class);
        ObjValidater.validateReq(req);
    }

}
