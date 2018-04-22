package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630422Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/*修改品牌*/

public class XN630422 extends AProcessor {
    private ICarAO carAO = SpringContextHolder.getBean(ICarAO.class);

    private XN630422Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        carAO.editCar(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630422Req.class);
        ObjValidater.validateReq(req);
    }
}
