package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IWithdrawAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN802752Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 批量审批线下取现订单
 * @author: myb858 
 * @since: 2017年4月24日 下午7:51:08 
 * @history:
 */
public class XN802752 extends AProcessor {
    private IWithdrawAO withdrawAO = SpringContextHolder
        .getBean(IWithdrawAO.class);

    private XN802752Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        synchronized (XN802752.class) {
            for (String code : req.getCodeList()) {
                withdrawAO.approveOrder(code, req.getApproveUser(),
                    req.getApproveResult(), req.getApproveNote());
            }
            return new BooleanRes(true);
        }
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802752Req.class);
        ObjValidater.validateReq(req);
    }
}
