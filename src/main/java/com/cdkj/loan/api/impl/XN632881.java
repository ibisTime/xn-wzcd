package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ITransferPositionApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632881Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 审核
 * @author: CYL 
 * @since: 2018年6月6日 下午1:24:58 
 * @history:
 */
public class XN632881 extends AProcessor {
    private ITransferPositionApplyAO transferPositionApplyAO = SpringContextHolder
        .getBean(ITransferPositionApplyAO.class);

    private XN632881Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        transferPositionApplyAO.approveTransferPositionApply(req.getCode(),
            req.getApproveResult(), req.getUpdater(), req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632881Req.class);
        ObjValidater.validateReq(req);
    }

}
