package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.IAdsAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.ObjValidater;
import com.cdkj.coin.dto.req.XN625226Req;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public class XN625226 extends AProcessor {

    private IAdsAO adsAO = SpringContextHolder
            .getBean(IAdsAO.class);

    XN625226Req req;

    @Override
    public Object doBusiness() throws BizException {
        return this.adsAO.adsDetail(req.getAdsCode(),req.getUserId());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {

        req = JsonUtil.json2Bean(inputparams, XN625226Req.class);
        ObjValidater.validateReq(req);
    }
}
