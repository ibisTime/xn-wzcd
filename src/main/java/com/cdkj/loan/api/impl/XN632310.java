package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBankRepointAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632310Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 录入结算费率
 * @author: jiafr 
 * @since: 2018年8月11日 下午1:38:38 
 * @history:
 */
public class XN632310 extends AProcessor {

    private IBankRepointAO bankRepointAO = SpringContextHolder
        .getBean(IBankRepointAO.class);

    private XN632310Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        bankRepointAO.entrySettleRate(req.getCodeList(), req.getSettleRate(),
            req.getOperator());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632310Req.class);
        ObjValidater.validateReq(req);

    }

}
