package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IGpsSupplierAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.GpsSupplier;
import com.cdkj.loan.dto.req.XN632787Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查GPS供应商
 * @author: CYL 
 * @since: 2018年8月20日 下午2:44:31 
 * @history:
 */
public class XN632787 extends AProcessor {

    private IGpsSupplierAO gpsSupplierAO = SpringContextHolder
        .getBean(IGpsSupplierAO.class);

    private XN632787Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        GpsSupplier condition = new GpsSupplier();
        condition.setName(req.getName());
        condition.setCode(req.getCode());
        return gpsSupplierAO.queryGpsSupplierList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632787Req.class);
        ObjValidater.validateReq(req);
    }
}
