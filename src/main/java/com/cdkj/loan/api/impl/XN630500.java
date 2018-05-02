package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ILoanOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630500Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增车贷订单
 * @author: CYL 
 * @since: 2018年4月30日 下午8:26:08 
 * @history:
 */
public class XN630500 extends AProcessor {
    private ILoanOrderAO loanOrderAO = SpringContextHolder
        .getBean(ILoanOrderAO.class);

    private XN630500Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(loanOrderAO.addLoanOrder(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630500Req.class);
        ObjValidater.validateReq(req);
    }

}
