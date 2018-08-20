package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IGpsSupplierAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632781Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改GPS供应商
 * @author: CYL 
 * @since: 2018年8月20日 下午2:44:31 
 * @history:
 */
public class XN632781 extends AProcessor {

    private IGpsSupplierAO gpsSupplierAO = SpringContextHolder
        .getBean(IGpsSupplierAO.class);

    private XN632781Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        gpsSupplierAO.editGpsSupplier(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632781Req.class);
        ObjValidater.validateReq(req);
    }
}
