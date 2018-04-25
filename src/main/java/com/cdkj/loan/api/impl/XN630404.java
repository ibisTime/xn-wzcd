package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBrandAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630404Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 品牌下架
 * @author: CYL 
 * @since: 2018年4月24日 下午5:34:42 
 * @history:
 */

public class XN630404 extends AProcessor {
    private IBrandAO brandAO = SpringContextHolder.getBean(IBrandAO.class);

    private XN630404Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        brandAO.downBrand(req.getCode(), req.getUpdater(), req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630404Req.class);
        ObjValidater.validateReq(req);
    }
}
