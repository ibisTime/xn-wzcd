package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRecruitApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632841Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 用人审核
 * @author: CYL 
 * @since: 2018年6月5日 上午12:27:48 
 * @history:
 */
public class XN632841 extends AProcessor {
    private IRecruitApplyAO recruitApplyAO = SpringContextHolder
        .getBean(IRecruitApplyAO.class);

    private XN632841Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        recruitApplyAO.auditRecruitApply(req.getCode(), req.getApproveResult(),
            req.getUpdater(), req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632841Req.class);
        ObjValidater.validateReq(req);
    }

}
