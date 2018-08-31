package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICompanyClearanceAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN632356Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查公司结清记录
 * @author: CYL 
 * @since: 2018年8月24日 下午5:28:39 
 * @history:
 */
public class XN632356 extends AProcessor {
    private ICompanyClearanceAO companyClearanceAO = SpringContextHolder
        .getBean(ICompanyClearanceAO.class);

    private XN632356Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return companyClearanceAO
            .getCompanyClearance(StringValidater.toInteger(req.getId()));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632356Req.class);
        ObjValidater.validateReq(req);
    }

}
