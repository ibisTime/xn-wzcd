package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IGpsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632701Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 回退GPS设备申请
 * @author: jiafr 
 * @since: 2018年7月30日 下午2:43:16 
 * @history:
 */
public class XN632701 extends AProcessor {
    private IGpsAO gpsAO = SpringContextHolder.getBean(IGpsAO.class);

    private XN632701Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        gpsAO.gpsSendBackApply(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632701Req.class);
        ObjValidater.validateReq(req);
    }

}
