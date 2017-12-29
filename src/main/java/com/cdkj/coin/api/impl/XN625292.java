package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.IMarketAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.ObjValidater;
import com.cdkj.coin.dto.req.XN625292Req;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

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
