package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBrandAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.dto.req.XN630403Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/*上架*/

public class XN630403 extends AProcessor {

    private IBrandAO brandAO = SpringContextHolder.getBean(IBrandAO.class);

    private XN630403Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        brandAO.upBrand(req.getCode(), req.getUpdater(), req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        // TODO Auto-generated method stub

    }

}
