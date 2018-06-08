package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IDayRestAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632680Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 保存休息日
 * @author: silver 
 * @since: 2018年6月8日 下午2:57:23 
 * @history:
 */
public class XN632680 extends AProcessor {

    private IDayRestAO dayRestAO = SpringContextHolder
        .getBean(IDayRestAO.class);

    private XN632680Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        dayRestAO.addDayRest(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632680Req.class);
        ObjValidater.validateReq(req);
    }
}
