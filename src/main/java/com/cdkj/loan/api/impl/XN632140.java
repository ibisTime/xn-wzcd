package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632140Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 银行放款确认提交
 * @author: silver 
 * @since: 2018年6月13日 下午2:42:47 
 * @history:
 */
public class XN632140 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632140Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        budgetOrderAO.refreshBankLoanCommit(req.getCode(),
            DateUtil.strToDate(req.getBankCommitDatetime(),
                DateUtil.FRONT_DATE_FORMAT_STRING),
            req.getBankCommitNote(), req.getOperator());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632140Req.class);
        ObjValidater.validateReq(req);
    }

}
