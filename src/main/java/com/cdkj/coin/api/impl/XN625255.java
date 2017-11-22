package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.ITradeOrderAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.ObjValidater;
import com.cdkj.coin.dto.req.XN625251Req;
import com.cdkj.coin.dto.req.XN625255Req;
import com.cdkj.coin.dto.res.XN625255Res;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

import java.math.BigDecimal;

/**
 * Created by tianlei on 2017/十一月/22.
 */
public class XN625255 extends AProcessor {

    private ITradeOrderAO tradeOrderAO = SpringContextHolder
            .getBean(ITradeOrderAO.class);

    private XN625255Req req;

    @Override
    public Object doBusiness() throws BizException {

        XN625255Res res = new XN625255Res();
        BigDecimal totalTradeCount = this.tradeOrderAO.getUserTotalTradeCount(req.getUserId());
        res.setTotalTradeCount(totalTradeCount.toString());
        return res;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {

        req = JsonUtil.json2Bean(inputparams, XN625255Req.class);
        ObjValidater.validateReq(req);
    }
}
