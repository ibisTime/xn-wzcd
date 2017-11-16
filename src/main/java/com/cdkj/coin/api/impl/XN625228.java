package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.IAdsAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.ObjValidater;
import com.cdkj.coin.domain.AdsSell;
import com.cdkj.coin.dto.req.XN625228Req;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public class XN625228 extends AProcessor {

    private IAdsAO adsAO = SpringContextHolder
            .getBean(IAdsAO.class);

    XN625228Req req;

    @Override
    public Object doBusiness() throws BizException {

        AdsSell condition = new AdsSell();

        return this.adsAO.frontSellPage(req.getStart(),req.getLimit(),condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {

        req = JsonUtil.json2Bean(inputparams, XN625228Req.class);
        ObjValidater.validateReq(req);
    }
}
