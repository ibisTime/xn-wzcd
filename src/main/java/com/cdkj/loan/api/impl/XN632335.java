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
 * 代偿审核确认放款
 * @author: jiafr 
 * @since: 2018年7月30日 上午10:02:07 
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
