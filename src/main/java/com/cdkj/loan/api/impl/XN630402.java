package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBrandAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630402Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/*修改品牌*/

public class XN630402 extends AProcessor {
    private IBrandAO brandAO = SpringContextHolder.getBean(IBrandAO.class);

    private XN630402Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        brandAO.editBrand(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630402Req.class);
        ObjValidater.validateReq(req);
    }
}
