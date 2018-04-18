package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IMarketAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN625292Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * Created by tianlei on 2017/十二月/05.
 */
public class XN625292 extends AProcessor {

    private IMarketAO marketAO = SpringContextHolder
            .getBean(IMarketAO.class);

    private XN625292Req req;

    @Override
    public Object doBusiness() throws BizException {

        return this.marketAO.coinPriceByPlatform(req.getCoin());

    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {

        req = JsonUtil.json2Bean(inputparams, XN625292Req.class);
        ObjValidater.validateReq(req);

    }
}
