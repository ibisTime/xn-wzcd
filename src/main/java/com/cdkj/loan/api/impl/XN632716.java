package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IGpsApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632716Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详细查询gps申领列表
 * @author: silver 
 * @since: 2018年5月31日 上午2:29:21 
 * @history:
 */
public class XN632716 extends AProcessor {
    private IGpsApplyAO gpsApplyAO = SpringContextHolder
        .getBean(IGpsApplyAO.class);

    private XN632716Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return gpsApplyAO.getGpsApply(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632716Req.class);
        ObjValidater.validateReq(req);
    }

}
