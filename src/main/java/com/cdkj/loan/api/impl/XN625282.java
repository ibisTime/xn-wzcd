package com.cdkj.loan.api.impl;

import java.util.prefs.AbstractPreferences;

import com.cdkj.loan.ao.ICurrencyRateAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.CurrencyRate;
import com.cdkj.loan.dto.req.XN625281Req;
import com.cdkj.loan.dto.req.XN625282Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

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
    public void doCheck(String inputparams, String operator) throws ParaException {

        req = JsonUtil.json2Bean(inputparams,XN625282Req.class);
        ObjValidater.validateReq(req);

    }
}
