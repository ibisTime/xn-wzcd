package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ICreditUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.dto.req.XN632119Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 632117征信详情查询
 * @author: jiafr 
 * @since: 2018年5月26日 下午2:33:29 
 * @history:
 */
public class XN632119 extends AProcessor {

    private ICreditUserAO creditUserAO = SpringContextHolder
        .getBean(ICreditUserAO.class);

    private XN632119Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CreditUser condition = new CreditUser();
        condition.setCode(req.getCode());
        condition.setCreditCode(req.getCreditCode());
        condition.setLoanRole(req.getLoanRole());
        condition.setIsFirstAudit(req.getIsFirstAudit());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICreditUserAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return creditUserAO.queryCreditUserList(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632119Req.class);
        ObjValidater.validateReq(req);

    }

}
