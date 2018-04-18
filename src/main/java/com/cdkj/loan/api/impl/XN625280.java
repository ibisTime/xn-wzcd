package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICurrencyRateAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN625280Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * Created by tianlei on 2017/十一月/13.
 */
public class XN625280 extends AProcessor {

    private ICurrencyRateAO ethAddressAO = SpringContextHolder
        .getBean(ICurrencyRateAO.class);

    private XN625280Req req;

    @Override
    public Object doBusiness() throws BizException {
        return this.ethAddressAO.currencyRateByCurrency(req.getCurrency());
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {

        req = JsonUtil.json2Bean(inputparams, XN625280Req.class);
        ObjValidater.validateReq(req);

    }
}
