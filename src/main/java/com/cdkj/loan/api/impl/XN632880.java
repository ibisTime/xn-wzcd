package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ITransferPositionApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632880Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 调岗申请
 * @author: CYL 
 * @since: 2018年6月6日 下午1:11:19 
 * @history:
 */
public class XN632880 extends AProcessor {
    private ITransferPositionApplyAO transferPositionApplyAO = SpringContextHolder
        .getBean(ITransferPositionApplyAO.class);

    private XN632880Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(
            transferPositionApplyAO.addTransferPositionApply(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632880Req.class);
        ObjValidater.validateReq(req);
    }

}
