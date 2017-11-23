package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.ICurrencyRateAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.ObjValidater;
import com.cdkj.coin.domain.CurrencyRate;
import com.cdkj.coin.dto.req.XN625281Req;
import com.cdkj.coin.dto.req.XN625282Req;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

import java.util.prefs.AbstractPreferences;

/**
 * Created by tianlei on 2017/十一月/22.
 */
public class XN625282 extends AProcessor {

    private ICurrencyRateAO currencyRateAO = SpringContextHolder
            .getBean(ICurrencyRateAO.class);

    private XN625282Req req;

    @Override
    public Object doBusiness() throws BizException {

        CurrencyRate condition = new CurrencyRate();
        condition.setCurrency(req.getCurrency());
        return this.currencyRateAO.queryPage(req.getStart(),req.getLimit(),condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {

        req = JsonUtil.json2Bean(inputparams,XN625282Req.class);
        ObjValidater.validateReq(req);

    }
}
