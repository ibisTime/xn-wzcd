package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632234Req;
import com.cdkj.loan.dto.res.XN632234Res;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改贷款金额计算关联数据
 * @author: jiafr 
 * @since: 2018年6月28日 下午9:44:24 
 * @history:
 */
public class XN632234 extends AProcessor {

    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632234Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        XN632234Res res = budgetOrderAO.modifyLoanAmountCalculateData(
            req.getCode(), req.getLoanAmount());
        return res;
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632234Req.class);
        ObjValidater.validateReq(req);
    }
}
