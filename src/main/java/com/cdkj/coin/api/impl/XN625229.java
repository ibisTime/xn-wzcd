package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.IAdsAO;
import com.cdkj.coin.ao.ITradeOrderAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.ObjValidater;
import com.cdkj.coin.dto.req.XN625229Req;
import com.cdkj.coin.dto.req.XN625255Req;
import com.cdkj.coin.dto.res.XN625255Res;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

import java.math.BigDecimal;

/**
 * Created by tianlei on 2017/十一月/22.
 */
public class XN625229 extends AProcessor {

    private IAdsAO adsAO = SpringContextHolder
            .getBean(IAdsAO.class);
    XN625229Req req;

    @Override
    public Object doBusiness() throws BizException {

        return this.adsAO.frontSearchAdsByNickName(req.getNickName());

    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {

        req = JsonUtil.json2Bean(inputparams, XN625229Req.class);
        ObjValidater.validateReq(req);
    }
}
