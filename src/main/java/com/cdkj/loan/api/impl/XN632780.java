package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IGpsSupplierAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632780Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增GPS供应商
 * @author: CYL 
 * @since: 2018年8月20日 下午2:44:31 
 * @history:
 */
public class XN632780 extends AProcessor {

    private IGpsSupplierAO gpsSupplierAO = SpringContextHolder
        .getBean(IGpsSupplierAO.class);

    private XN632780Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(gpsSupplierAO.addGpsSupplier(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632780Req.class);
        ObjValidater.validateReq(req);
    }
}
