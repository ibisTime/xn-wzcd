package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IAdvanceFundAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.AdvanceFund;
import com.cdkj.loan.dto.req.XN632179Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 今日已垫资
 * @author: jiafr 
 * @since: 2018年8月20日 下午8:08:47 
 * @history:
 */
public class XN632179 extends AProcessor {

    private IAdvanceFundAO advanceFundAO = SpringContextHolder
        .getBean(IAdvanceFundAO.class);

    private XN632179Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        AdvanceFund condition = new AdvanceFund();
        condition.setCustomerName(req.getCustomerName());
        condition.setBudgetCode(req.getBizCode());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setLoanBankCode(req.getLoanBankCode());

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IAdvanceFundAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return advanceFundAO.todayHasAdvanceFund(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632179Req.class);
        ObjValidater.validateReq(req);
    }
}
