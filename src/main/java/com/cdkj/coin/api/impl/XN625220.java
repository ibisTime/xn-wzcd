package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.IAdsSellAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.ObjValidater;
import com.cdkj.coin.dto.req.XN625220Req;
import com.cdkj.coin.dto.res.BooleanRes;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public class XN625220 extends AProcessor {

    private IAdsSellAO adsAO = SpringContextHolder
            .getBean(IAdsSellAO.class);

    private XN625220Req req;

    @Override
    public Object doBusiness() throws BizException {

         this.adsAO.insertAds(req);
         return new BooleanRes(true);

    }

    @Override
    public void doCheck(String inputparams) throws ParaException {

        req = JsonUtil.json2Bean(inputparams,XN625220Req.class);
        ObjValidater.validateReq(req);

    }
}
