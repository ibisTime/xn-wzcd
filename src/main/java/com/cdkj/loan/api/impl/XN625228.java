package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAdsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Ads;
import com.cdkj.loan.dto.req.XN625228Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public class XN625228 extends AProcessor {

    private IAdsAO adsAO = SpringContextHolder
            .getBean(IAdsAO.class);

    XN625228Req req;

    @Override
    public Object doBusiness() throws BizException {

        Ads condition = new Ads();
        condition.setTradeCoin(req.getCoin());
        condition.setTradeType(req.getTradeType());
        condition.setPayType(req.getPayType());
        condition.setMaxPrice(req.getMaxPrice());
        condition.setMinPrice(req.getMinPrice());
        return this.adsAO.frontPage(req.getStart(),req.getLimit(),condition);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {

        req = JsonUtil.json2Bean(inputparams, XN625228Req.class);
        ObjValidater.validateReq(req);
    }
}
