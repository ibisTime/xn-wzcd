package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IWelfareApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632661Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 福利发放审核
 * @author: silver 
 * @since: 2018年6月6日 下午7:27:35 
 * @history:
 */
public class XN632661 extends AProcessor {

    private IWelfareApplyAO welfareApplyAO = SpringContextHolder
        .getBean(IWelfareApplyAO.class);

    private XN632661Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        welfareApplyAO.approveWelfareApply(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632661Req.class);
        ObjValidater.validateReq(req);
    }
}
