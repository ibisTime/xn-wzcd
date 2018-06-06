package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRecruitApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632840Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 用人申请
 * @author: CYL 
 * @since: 2018年6月5日 上午12:27:48 
 * @history:
 */
public class XN632840 extends AProcessor {
    private IRecruitApplyAO recruitApplyAO = SpringContextHolder
        .getBean(IRecruitApplyAO.class);

    private XN632840Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(recruitApplyAO.addRecruitApply(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632840Req.class);
        ObjValidater.validateReq(req);
    }

}
