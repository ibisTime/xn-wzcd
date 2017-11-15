package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.IAdsAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.ObjValidater;
import com.cdkj.coin.dto.req.XN625220Req;
import com.cdkj.coin.dto.req.XN625224Req;
import com.cdkj.coin.dto.res.BooleanRes;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/**
 * Created by tianlei on 2017/十一月/15.
 */
public class XN625224 extends AProcessor {

    private IAdsAO adsAO = SpringContextHolder
            .getBean(IAdsAO.class);

    XN625224Req req;

    @Override
    public Object doBusiness() throws BizException {

        this.adsAO.xiaJiaAds(req.getAdsCode(), req.getUserId(), req.getTradeType());
        return new BooleanRes(true);

    }

    @Override
    public void doCheck(String inputparams) throws ParaException {

        req = JsonUtil.json2Bean(inputparams, XN625224Req.class);
        ObjValidater.validateReq(req);
    }
}
