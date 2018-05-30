package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632136Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 预算单详情查询
 * @author: CYL 
 * @since: 2018年5月30日 下午10:08:03 
 * @history:
 */
public class XN632136 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632136Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return budgetOrderAO.getBudgetOrder(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632136Req.class);
        ObjValidater.validateReq(req);
    }

}
