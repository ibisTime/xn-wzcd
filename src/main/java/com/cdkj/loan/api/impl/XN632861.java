package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IEntryApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632861Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 入职申请审核
 * @author: CYL 
 * @since: 2018年8月11日 上午10:32:47 
 * @history:
 */
public class XN632861 extends AProcessor {
    private IEntryApplyAO entryApplyAO = SpringContextHolder
        .getBean(IEntryApplyAO.class);

    private XN632861Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        entryApplyAO.approveEntryApply(req.getCode(), req.getApproveResult(),
            req.getUpdater(), req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632861Req.class);
        ObjValidater.validateReq(req);
    }

}
