package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAdvanceFundAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632170Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 垫资确认用款单
 * @author: jiafr 
 * @since: 2018年6月15日 下午10:33:06 
 * @history:
 */
public class XN632170 extends AProcessor {
    private IAdvanceFundAO advanceFundAO = SpringContextHolder
        .getBean(IAdvanceFundAO.class);

    private XN632170Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        advanceFundAO.confirmAdvanceFund(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632170Req.class);
        ObjValidater.validateReq(req);
    }

}
