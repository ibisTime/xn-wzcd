package com.cdkj.coin.api.impl;

import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.ObjValidater;
import com.cdkj.coin.dto.req.XN625220Req;
import com.cdkj.coin.dto.req.XN625280Req;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public class XN625220 extends AProcessor {

    private XN625220Req req;

    @Override
    public Object doBusiness() throws BizException {
        return null;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {

        req = JsonUtil.json2Bean(inputparams,XN625220Req.class);
        ObjValidater.validateReq(req);

    }
}
