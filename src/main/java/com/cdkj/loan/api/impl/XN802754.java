package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IWithdrawAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN802754Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 提现广播
 * @author: haiqingzheng 
 * @since: 2017年11月8日 下午2:07:37 
 * @history:
 */
public class XN802754 extends AProcessor {
    private IWithdrawAO withdrawAO = SpringContextHolder
        .getBean(IWithdrawAO.class);

    private XN802754Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        withdrawAO.broadcast(req.getCode(), req.getmAddressCode(),
            req.getApproveUser());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802754Req.class);
        ObjValidater.validateReq(req);
    }

}
