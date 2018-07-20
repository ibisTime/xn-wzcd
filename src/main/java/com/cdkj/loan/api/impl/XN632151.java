package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ILogisticsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632151Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 收件
 * @author: jiafr 
 * @since: 2018年7月15日 下午3:15:34 
 * @history:
 */
public class XN632151 extends AProcessor {
    private ILogisticsAO logisticsAO = SpringContextHolder
        .getBean(ILogisticsAO.class);

    private XN632151Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        logisticsAO.receiveLogistics(req.getCodeList(), req.getOperator(),
            req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632151Req.class);
        ObjValidater.validateReq(req);
    }

}
