package com.cdkj.loan.api.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdkj.loan.ao.ICurrencyRateAO;
import com.cdkj.loan.ao.IEthAddressAO;
import com.cdkj.loan.ao.IMarketAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN625280Req;
import com.cdkj.loan.dto.req.XN625281Req;
import com.cdkj.loan.dto.req.XN625290Req;
import com.cdkj.loan.dto.req.XN625291Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * Created by tianlei on 2017/十一月/13.
 */
public class XN625291 extends AProcessor {

    private IMarketAO marketAO = SpringContextHolder
            .getBean(IMarketAO.class);

    private XN625291Req req;

    @Override
    public Object doBusiness() throws BizException {

        return  this.marketAO.marketListByReq(req);

    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {

        req = JsonUtil.json2Bean(inputparams,XN625291Req.class);
        ObjValidater.validateReq(req);

    }
}
