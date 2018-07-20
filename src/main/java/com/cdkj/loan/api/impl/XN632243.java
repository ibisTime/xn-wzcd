package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepointAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632243Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 返点财务确认
 * @author: jiafr 
 * @since: 2018年6月18日 下午2:20:00 
 * @history:
 */
public class XN632243 extends AProcessor {
    private IRepointAO repointAO = SpringContextHolder
        .getBean(IRepointAO.class);

    private XN632243Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        repointAO.financeConfirm(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632243Req.class);
        ObjValidater.validateReq(req);
    }

}
