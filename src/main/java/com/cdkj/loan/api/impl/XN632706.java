package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IGpsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632706Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询gps列表
 * @author: xieyj 
 * @since: 2018年5月26日 下午9:22:19 
 * @history:
 */
public class XN632706 extends AProcessor {
    private IGpsAO gpsAO = SpringContextHolder.getBean(IGpsAO.class);

    private XN632706Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return gpsAO.getGps(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632706Req.class);
        ObjValidater.validateReq(req);
    }

}
