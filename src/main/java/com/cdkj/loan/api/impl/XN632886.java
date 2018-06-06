package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ITransferPositionApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632886Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查
 * @author: CYL 
 * @since: 2018年6月6日 下午1:24:58 
 * @history:
 */
public class XN632886 extends AProcessor {
    private ITransferPositionApplyAO transferPositionApplyAO = SpringContextHolder
        .getBean(ITransferPositionApplyAO.class);

    private XN632886Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return transferPositionApplyAO.getTransferPositionApply(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632886Req.class);
        ObjValidater.validateReq(req);
    }

}
