package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IAssertApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
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
public class XN632645 extends AProcessor {

    private IAssertApplyAO assertApplyAO = SpringContextHolder
        .getBean(IAssertApplyAO.class);

    private XN632645Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        AssertApply condition = new AssertApply();
        condition.setType(req.getType());
        condition.setApplyUser(req.getApplyUser());
        condition.setDepartmentCode(req.getDepartmentCode());
        condition.setStartApplyDatetime(DateUtil.getFrontDate(
            req.getStartApplyDatetime(), false));
        condition.setEndApplyDatetime(DateUtil.getFrontDate(
            req.getEndApplyDatetime(), true));
        condition.setStatus(req.getStatus());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IAssertApplyAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return assertApplyAO.queryAssertApplyPageByDepartmentCode(start, limit,
            condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632645Req.class);
        ObjValidater.validateReq(req);
    }
}
