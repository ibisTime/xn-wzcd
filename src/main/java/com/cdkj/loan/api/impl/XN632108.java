package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IReqBudgetAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.ReqBudget;
import com.cdkj.loan.dto.req.XN632108Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 请款预算单分页查询(按角色权限)
 * @author: xieyj 
 * @since: 2018年5月24日 下午1:31:28 
 * @history:
 */
public class XN632108 extends AProcessor {
    private IReqBudgetAO reqBudgetAO = SpringContextHolder
        .getBean(IReqBudgetAO.class);

    private XN632108Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ReqBudget condition = new ReqBudget();
        condition.setCompanyCode(req.getCompanyCode());
        condition.setApplyDatetimeStart(DateUtil.strToDate(
            req.getApplyDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setApplyDatetimeEnd(DateUtil.strToDate(
            req.getApplyDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setRoleCode(req.getRoleCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IReqBudgetAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return reqBudgetAO
            .queryReqBudgetPageByRoleCode(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632108Req.class);
        ObjValidater.validateReq(req);
    }
}
