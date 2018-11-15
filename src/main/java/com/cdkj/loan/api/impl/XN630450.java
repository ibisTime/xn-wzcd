package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBasicValuationAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630450Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 基础估值
 * @author: CYL 
 * @since: 2018年11月15日 下午6:56:58 
 * @history:
 */
public class XN630450 extends AProcessor {

    private IBasicValuationAO basicValuationAO = SpringContextHolder
        .getBean(IBasicValuationAO.class);

    private XN630450Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return basicValuationAO.basicValuation(req);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630450Req.class);
        ObjValidater.validateReq(req);
    }

}
