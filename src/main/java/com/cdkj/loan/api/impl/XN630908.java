package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630908Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 业绩完成情况统计
 * @author: jiafr 
 * @since: 2018年8月21日 上午11:41:26 
 * @history:
 */
public class XN630908 extends AProcessor {

    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN630908Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return budgetOrderAO.performanceCompletionSituation(req);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630908Req.class);
        ObjValidater.validateReq(req);
    }
}
