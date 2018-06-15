package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ILoanCsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632086Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详细查询贷款成数
 * @author: silver 
 * @since: 2018年6月14日 下午7:47:37 
 * @history:
 */
public class XN632086 extends AProcessor {
    private ILoanCsAO loanCsAO = SpringContextHolder.getBean(ILoanCsAO.class);

    private XN632086Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return loanCsAO.getLoanCs(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632086Req.class);
        ObjValidater.validateReq(req);
    }

}
