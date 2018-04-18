package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IHLOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN802801Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 人工调账
 * @author: myb858 
 * @since: 2017年4月24日 下午5:43:53 
 * @history:
 */
public class XN802801 extends AProcessor {
    private IHLOrderAO hlOrderAO = SpringContextHolder
        .getBean(IHLOrderAO.class);

    private XN802801Req req = null;

    @Override
    public synchronized Object doBusiness() throws BizException {
        hlOrderAO.approveOrder(req.getCode(), req.getAdjustResult(),
            req.getAdjustUser(), req.getAdjustNote(), req.getSystemCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802801Req.class);
        StringValidater.validateBlank(req.getCode(), req.getAdjustResult(),
            req.getAdjustUser(), req.getAdjustNote(), req.getSystemCode());
    }
}
