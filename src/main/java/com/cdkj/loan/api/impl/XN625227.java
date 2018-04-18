package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAdsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Ads;
import com.cdkj.loan.dto.req.XN625227Req;
import com.cdkj.loan.enums.ETradeType;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public class XN625227 extends AProcessor {

    private IAdsAO adsAO = SpringContextHolder
            .getBean(IAdsAO.class);

    XN625227Req req;

    @Override
    public Object doBusiness() throws BizException {


        Ads condition = new Ads();
        condition.setTradeCoin(req.getCoin());
        condition.setUserId(req.getUserId());
        condition.setTradeType(req.getTradeType());
        condition.setPayType(req.getPayType());
        condition.setTradeCoin(req.getCoin());
        condition.setStatus(req.getStatus());
        condition.setOnlyTrust(req.getOnlyTrust());
        condition.setStatusList(req.getStatusList());
        return this.adsAO.ossPage(req.getStart(), req.getLimit(), condition);

    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {

        req = JsonUtil.json2Bean(inputparams, XN625227Req.class);
        ObjValidater.validateReq(req);
    }
}
