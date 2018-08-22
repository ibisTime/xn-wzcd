package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630909Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 月度业绩完成情况表
 * @author: jiafr 
 * @since: 2018年8月22日 上午10:41:07 
 * @history:
 */
public class XN630909 extends AProcessor {

    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN630909Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return budgetOrderAO.monthPerformanceCompletionSituation(req);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630909Req.class);
        ObjValidater.validateReq(req);
    }
}
