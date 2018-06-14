package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ILoanCsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632080Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 贷款成数
 * @author: silver 
 * @since: 2018年6月14日 下午7:35:05 
 * @history:
 */
public class XN632080 extends AProcessor {

    private ILoanCsAO loanCsAO = SpringContextHolder.getBean(ILoanCsAO.class);

    private XN632080Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        loanCsAO.editLoanCs(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632080Req.class);
        ObjValidater.validateReq(req);
    }
}
