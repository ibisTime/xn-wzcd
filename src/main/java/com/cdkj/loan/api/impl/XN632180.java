package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632180Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 车辆抵押确认提交银行
 * @author: silver 
 * @since: 2018年6月13日 下午2:42:47 
 * @history:
 */
public class XN632180 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632180Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        budgetOrderAO.refreshCarPledgeCommit(req.getCode(),
            DateUtil.strToDate(req.getPledgeCommitDatetime(),
                DateUtil.FRONT_DATE_FORMAT_STRING),
            req.getPledgeCommitNote(), req.getOperator());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632180Req.class);
        ObjValidater.validateReq(req);
    }

}
