package com.cdkj.loan.api.impl;

import java.util.Date;

import com.cdkj.loan.ao.IAssertApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.AssertApply;
import com.cdkj.loan.dto.req.XN632641Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 审核办公用品/固定资产申请
 * @author: jiafr 
 * @since: 2018年6月6日 下午1:58:59 
 * @history:
 */
public class XN632641 extends AProcessor {
    private IAssertApplyAO assertApplyAO = SpringContextHolder
        .getBean(IAssertApplyAO.class);

    private XN632641Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        AssertApply data = new AssertApply();
        data.setCode(req.getCode());
        data.setStatus(req.getApproveResult());
        data.setRemark(req.getRemark());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        assertApplyAO.editAssertApply(data);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632641Req.class);
        ObjValidater.validateReq(req);
    }

}
