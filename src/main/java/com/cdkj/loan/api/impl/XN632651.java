package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAskForApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632651Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 审核
 * @author: CYL 
 * @since: 2018年6月5日 下午9:50:31 
 * @history:
 */
public class XN632651 extends AProcessor {
    private IAskForApplyAO askForApplyAO = SpringContextHolder
        .getBean(IAskForApplyAO.class);

    private XN632651Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        askForApplyAO.approveAskForApply(req.getCode(), req.getApproveResult(),
            req.getUpdater(), req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632651Req.class);
        ObjValidater.validateReq(req);
    }

}
