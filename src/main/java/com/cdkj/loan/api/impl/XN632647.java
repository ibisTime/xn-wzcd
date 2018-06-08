package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAssertApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.AssertApply;
import com.cdkj.loan.dto.req.XN632645Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询办公用品/固定资产申请
 * @author: jiafr 
 * @since: 2018年6月6日 下午10:27:51 
 * @history:
 */
public class XN632647 extends AProcessor {

    private IAssertApplyAO assertApplyAO = SpringContextHolder
        .getBean(IAssertApplyAO.class);

    private XN632645Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        AssertApply condition = new AssertApply();
        condition.setApplyUser(req.getApplyUser());
        condition.setStartApplyDatetime(req.getStartApplyDatetime());
        condition.setEndApplyDatetime(req.getEndApplyDatetime());
        condition.setStatus(req.getStatus());
        condition.setDepartmentCode(req.getDepartmentCode());

        return assertApplyAO.queryAssertApplyList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632645Req.class);
        ObjValidater.validateReq(req);
    }
}
