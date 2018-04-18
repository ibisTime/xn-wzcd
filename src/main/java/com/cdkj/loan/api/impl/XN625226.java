package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAdsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN625226Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

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
    public void doCheck(String inputparams, String operator) throws ParaException {

        req = JsonUtil.json2Bean(inputparams, XN625226Req.class);
        ObjValidater.validateReq(req);
    }
}
