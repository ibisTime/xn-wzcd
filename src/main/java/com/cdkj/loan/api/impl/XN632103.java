package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IReqBudgetAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632103Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 收回预算款
 * @author: CYL 
 * @since: 2018年5月23日 下午7:22:13 
 * @history:
 */
public class XN632103 extends AProcessor {

    private IReqBudgetAO reqBudgetAO = SpringContextHolder
        .getBean(IReqBudgetAO.class);

    private XN632103Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        reqBudgetAO.editReqBudget(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632103Req.class);
        ObjValidater.validateReq(req);
    }
}
