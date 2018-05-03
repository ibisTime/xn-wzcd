package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ILoanOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630507Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询
 * @author: CYL 
 * @since: 2018年4月24日 下午5:40:53 
 * @history:
 */
public class XN630507 extends AProcessor {

    private ILoanOrderAO loanOrderAO = SpringContextHolder
        .getBean(ILoanOrderAO.class);

    private XN630507Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return loanOrderAO.getLoanOrder(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630507Req.class);
        ObjValidater.validateReq(req);
    }

}
