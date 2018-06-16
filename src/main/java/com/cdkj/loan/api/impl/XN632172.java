package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAdvanceFundAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632172Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 垫资省分公司总经理审核
 * @author: jiafr 
 * @since: 2018年6月16日 上午10:36:57 
 * @history:
 */
public class XN632172 extends AProcessor {
    private IAdvanceFundAO advanceFundAO = SpringContextHolder
        .getBean(IAdvanceFundAO.class);

    private XN632172Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        advanceFundAO.provinceAudit(req);

        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632172Req.class);
        ObjValidater.validateReq(req);
    }

}
