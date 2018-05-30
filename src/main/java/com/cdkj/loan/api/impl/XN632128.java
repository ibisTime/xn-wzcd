package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632128Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 预算单-车辆落户
 * @author: CYL 
 * @since: 2018年5月30日 下午2:40:12 
 * @history:
 */
public class XN632128 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632128Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        budgetOrderAO.carSettle(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632128Req.class);
        ObjValidater.validateReq(req);
    }

}
