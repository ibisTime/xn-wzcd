package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632125Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 预算单-财务确认垫资
 * @author: CYL 
 * @since: 2018年5月30日 下午2:40:12 
 * @history:
 */
public class XN632125 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632125Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        budgetOrderAO.advanceFund(req.getCode(), req.getOperator(),
            req.getAdvanceFundDatetime(), req.getAdvanceFundAmount(),
            req.getBillPdf());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632125Req.class);
        ObjValidater.validateReq(req);
    }

}
