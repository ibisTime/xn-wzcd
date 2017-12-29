package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.ICurrencyRateAO;
import com.cdkj.coin.ao.IEthAddressAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.ObjValidater;
import com.cdkj.coin.dto.req.XN625280Req;
import com.cdkj.coin.dto.req.XN625281Req;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tianlei on 2017/十一月/13.
 */
public class XN625281 extends AProcessor {

    private ICurrencyRateAO currencyRateAO = SpringContextHolder
            .getBean(ICurrencyRateAO.class);

    private XN625281Req req;

    @Override
    public Object doBusiness() throws BizException {
        return this.currencyRateAO.allCurrencyRate();
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {

        req = JsonUtil.json2Bean(inputparams,XN625281Req.class);
        ObjValidater.validateReq(req);

    }
}
