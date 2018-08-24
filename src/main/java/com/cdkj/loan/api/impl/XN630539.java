package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IOverdueTreatmentAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630539Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查逾期处理
 * @author: CYL 
 * @since: 2018年8月2日 下午8:19:36 
 * @history:
 */
public class XN630539 extends AProcessor {

    private IOverdueTreatmentAO overdueTreatmentAO = SpringContextHolder
        .getBean(IOverdueTreatmentAO.class);

    private XN630539Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return overdueTreatmentAO.getOverdueTreatment(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630539Req.class);
        ObjValidater.validateReq(req);
    }

}
