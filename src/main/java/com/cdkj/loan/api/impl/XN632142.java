package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632142Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 银行放款合同打印
 * @author: CYL 
 * @since: 2018年6月30日 下午1:47:12 
 * @history:
 */
public class XN632142 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632142Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        budgetOrderAO.loanContractPrint(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632142Req.class);
        ObjValidater.validateReq(req);
    }

}
