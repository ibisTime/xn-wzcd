package com.cdkj.loan.api.impl;

import java.math.BigDecimal;

import com.cdkj.loan.ao.ITradeOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN625251Req;
import com.cdkj.loan.dto.req.XN625255Req;
import com.cdkj.loan.dto.res.XN625255Res;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

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
    public void doCheck(String inputparams, String operator) throws ParaException {

        req = JsonUtil.json2Bean(inputparams, XN625255Req.class);
        ObjValidater.validateReq(req);
    }
}
