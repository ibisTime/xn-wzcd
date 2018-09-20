package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632690Req;
import com.cdkj.loan.dto.res.XN632690Res;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 计算器
 * @author: CYL 
 * @since: 2018年8月6日 下午7:20:02 
 * @history:
 */
public class XN632690 extends AProcessor {

    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632690Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        XN632690Res res = budgetOrderAO.calculation(req.getLoanBankCode(),
            req.getLoanPeriods(), req.getLoanAmount(), req.getRateType(),
            req.getServiceChargeWay(), req.getBankRate(),
            req.getBankBenchmarkRate(), req.getSurcharge());
        return res;
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632690Req.class);
        ObjValidater.validateReq(req);
    }

}
