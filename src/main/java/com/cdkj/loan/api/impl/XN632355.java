package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ICompanyClearanceAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CompanyClearance;
import com.cdkj.loan.dto.req.XN632355Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查公司结清记录
 * @author: CYL 
 * @since: 2018年8月24日 下午5:28:39 
 * @history:
 */
public class XN632355 extends AProcessor {
    private ICompanyClearanceAO companyClearanceAO = SpringContextHolder
        .getBean(ICompanyClearanceAO.class);

    private XN632355Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CompanyClearance condition = new CompanyClearance();
        condition.setRepaybizCode(req.getRepaybizCode());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICompanyClearanceAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return companyClearanceAO.queryCompanyClearancePage(start, limit,
            condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632355Req.class);
        ObjValidater.validateReq(req);
    }

}
