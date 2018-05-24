package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IReqBudgetAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632100Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 申请或发送预算单
 * @author: xieyj 
 * @since: 2018年5月24日 下午1:08:53 
 * @history:
 */
public class XN632100 extends AProcessor {
    private IReqBudgetAO reqBudgetAO = SpringContextHolder
        .getBean(IReqBudgetAO.class);

    private XN632100Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        String code = reqBudgetAO.addReqBudget(req);
        return new PKCodeRes(code);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632100Req.class);
        ObjValidater.validateReq(req);
    }

}
