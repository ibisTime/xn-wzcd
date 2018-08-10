package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAssertApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632640Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增办公用品/固定资产申请
 * @author: jiafr 
 * @since: 2018年6月6日 下午5:55:04 
 * @history:
 */
public class XN632640 extends AProcessor {
    private IAssertApplyAO assertApplyAO = SpringContextHolder
        .getBean(IAssertApplyAO.class);

    private XN632640Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        return new PKCodeRes(assertApplyAO.addAssertApply(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632640Req.class);
        ObjValidater.validateReq(req);
    }

}
