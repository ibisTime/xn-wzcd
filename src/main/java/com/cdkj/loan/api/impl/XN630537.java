package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayPlanAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630537Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 催收过程
 * @author: CYL 
 * @since: 2018年8月2日 下午8:19:36 
 * @history:
 */
public class XN630537 extends AProcessor {

    private IRepayPlanAO repayPlanAO = SpringContextHolder
        .getBean(IRepayPlanAO.class);

    private XN630537Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        repayPlanAO.collectionProcess(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630537Req.class);
        ObjValidater.validateReq(req);
    }

}
