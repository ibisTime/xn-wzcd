package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAdsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN625224Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * Created by tianlei on 2017/十一月/15.
 */
public class XN625224 extends AProcessor {

    private IAdsAO adsAO = SpringContextHolder.getBean(IAdsAO.class);

    XN625224Req req;

    @Override
    public Object doBusiness() throws BizException {

        this.adsAO.xiaJiaAds(req.getAdsCode(), req.getUserId());
        return new BooleanRes(true);

    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {

        req = JsonUtil.json2Bean(inputparams, XN625224Req.class);
        req.setUserId(operator);
        ObjValidater.validateReq(req);
    }
}
