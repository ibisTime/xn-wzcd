package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.IAdsAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.ObjValidater;
import com.cdkj.coin.dto.req.XN625220Req;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/**
 * Created by tianlei on 2017/十一月/15.
 */
public class XN625221 extends AProcessor {

    //草稿发布为广告
    private IAdsAO adsAO = SpringContextHolder
            .getBean(IAdsAO.class);
    XN625220Req req;

    @Override
    public Object doBusiness() throws BizException {

        throw new BizException("xn000", "请调用625220");
//        this.adsAO.draftPublish(req);
//        return new BooleanRes(true);

    }

    @Override
    public void doCheck(String inputparams) throws ParaException {

        req = JsonUtil.json2Bean(inputparams, XN625220Req.class);
        ObjValidater.validateReq(req);

    }
}

