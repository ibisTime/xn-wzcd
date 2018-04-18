package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAdsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN625220Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * Created by tianlei on 2017/十一月/16.
 */
public class XN625225 extends AProcessor {

    private IAdsAO adsAO = SpringContextHolder.getBean(IAdsAO.class);

    private XN625220Req req;

    @Override
    public Object doBusiness() throws BizException {

        // this.adsAO.shangJia(req);
        return new BooleanRes(false);

    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {

        req = JsonUtil.json2Bean(inputparams, XN625220Req.class);
        req.setUserId(operator);
        ObjValidater.validateReq(req);
    }
}
