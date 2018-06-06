package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IFeeAdvanceApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.FeeAdvanceApply;
import com.cdkj.loan.dto.req.XN632675Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 费用提前申请分页查询
 * @author: xieyj 
 * @since: 2018年6月6日 下午10:34:02 
 * @history:
 */
public class XN632675 extends AProcessor {
    private IFeeAdvanceApplyAO feeAdvanceApplyAO = SpringContextHolder
        .getBean(IFeeAdvanceApplyAO.class);

    private XN632675Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FeeAdvanceApply condition = new FeeAdvanceApply();
        condition.setType(req.getType());
        condition.setRefAssertCode(req.getRefAssertCode());
        condition.setRefBudgetOrderCode(req.getRefBudgetOrderCode());
        condition.setStatus(req.getStatus());

        condition.setApplyUser(req.getApplyUser());
        condition.setApplyDateStart(DateUtil.getFrontDate(
            req.getApplyDateStart(), false));
        condition.setApplyDateEnd(DateUtil.getFrontDate(req.getApplyDateEnd(),
            true));
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IFeeAdvanceApplyAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return feeAdvanceApplyAO.queryFeeAdvanceApplyPage(start, limit,
            condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632675Req.class);
        ObjValidater.validateReq(req);
    }

}
