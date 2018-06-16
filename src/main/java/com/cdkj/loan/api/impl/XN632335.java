package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IReplaceRepayPlanAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632335Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 确认放款
 * @author: silver 
 * @since: 2018年6月15日 下午7:33:23 
 * @history:
 */
public class XN632335 extends AProcessor {
    private IReplaceRepayPlanAO replaceRepayPlanAO = SpringContextHolder
        .getBean(IReplaceRepayPlanAO.class);

    private XN632335Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        replaceRepayPlanAO.updateConfirmLoan(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632335Req.class);
        ObjValidater.validateReq(req);
    }

}
