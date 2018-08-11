package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBankRepointDetailAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632312Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 录入返佣到账金额
 * @author: jiafr 
 * @since: 2018年8月11日 下午2:01:21 
 * @history:
 */
public class XN632312 extends AProcessor {

    private IBankRepointDetailAO bankRepointDetailAO = SpringContextHolder
        .getBean(IBankRepointDetailAO.class);

    private XN632312Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        bankRepointDetailAO.entryRepointAmount(req.getCode(), req.getAmount(),
            req.getBillPdf(), req.getOperator());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632312Req.class);
        ObjValidater.validateReq(req);
    }

}
