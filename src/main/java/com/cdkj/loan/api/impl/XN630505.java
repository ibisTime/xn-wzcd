package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ILoanOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.LoanOrder;
import com.cdkj.loan.dto.req.XN630505Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询
 * @author: CYL 
 * @since: 2018年4月24日 下午5:40:27 
 * @history:
 */

public class XN630505 extends AProcessor {

    private ILoanOrderAO loanOrderAO = SpringContextHolder
        .getBean(ILoanOrderAO.class);

    private XN630505Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        LoanOrder condition = new LoanOrder();
        condition.setMobile(req.getMobile());
        condition.setIdNo(req.getIdNo());
        condition.setRealName(req.getRealName());
        condition.setStatus(req.getStatus());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ILoanOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());

        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return loanOrderAO.queryLoanOrderPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630505Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }

}
