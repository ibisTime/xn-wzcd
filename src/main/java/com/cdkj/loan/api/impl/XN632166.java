package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderFeeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632166Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 手续费详情
 * @author: jiafr 
 * @since: 2018年5月30日 下午9:41:27 
 * @history:
 */
public class XN632166 extends AProcessor {
    private IBudgetOrderFeeAO budgetOrderFeeAO = SpringContextHolder
        .getBean(IBudgetOrderFeeAO.class);

    private XN632166Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return budgetOrderFeeAO.getBudgetOrderFee(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632166Req.class);
        ObjValidater.validateReq(req);
    }
}
