package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IGpsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632700Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增gps
 * @author: xieyj 
 * @since: 2018年5月26日 下午9:10:39 
 * @history:
 */
public class XN632700 extends AProcessor {
    private IGpsAO gpsAO = SpringContextHolder.getBean(IGpsAO.class);

    private XN632700Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        String code = gpsAO.addGps(req.getGpsDevNo(), req.getGpsType(),
            req.getSupplierCode());
        return new PKCodeRes(code);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632700Req.class);
        ObjValidater.validateReq(req);
    }

}
