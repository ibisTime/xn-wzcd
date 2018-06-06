package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IWelfareApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632660Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 福利发放
 * @author: silver 
 * @since: 2018年6月6日 下午7:22:48 
 * @history:
 */
public class XN632660 extends AProcessor {

    private IWelfareApplyAO welfareApplyAO = SpringContextHolder
        .getBean(IWelfareApplyAO.class);

    private XN632660Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(welfareApplyAO.addWelfareApply(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632660Req.class);
        ObjValidater.validateReq(req);
    }
}
