package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.ITradeOrderAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.ObjValidater;
import com.cdkj.coin.dto.req.XN625255Req;
import com.cdkj.coin.dto.req.XN625256Req;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/**
 * Created by tianlei on 2017/十一月/23.
 */
public class XN625256 extends AProcessor {

    private ITradeOrderAO tradeOrderAO = SpringContextHolder
            .getBean(ITradeOrderAO.class);

    private XN625256Req req;

    @Override
    public Object doBusiness() throws BizException {

        return this.tradeOrderAO.userStatisticsInfo(req.getUserId());

    }

    @Override
    public void doCheck(String inputparams) throws ParaException {

        req = JsonUtil.json2Bean(inputparams, XN625256Req.class);
        ObjValidater.validateReq(req);

    }
}
