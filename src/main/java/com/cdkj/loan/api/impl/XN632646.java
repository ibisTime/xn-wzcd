package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAssertApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632646Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询办公用品申请
 * @author: jiafr 
 * @since: 2018年6月7日 上午11:44:11 
 * @history:
 */
public class XN632646 extends AProcessor {
    private IAssertApplyAO assertApplyAO = SpringContextHolder
        .getBean(IAssertApplyAO.class);

    private XN632646Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return assertApplyAO.getAssertApply(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632646Req.class);
        ObjValidater.validateReq(req);
    }
}
