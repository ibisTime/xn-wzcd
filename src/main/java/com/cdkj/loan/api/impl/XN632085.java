package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ILoanCsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.LoanCs;
import com.cdkj.loan.dto.req.XN632085Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 贷款成数分页查
 * @author: silver 
 * @since: 2018年6月14日 下午7:45:45 
 * @history:
 */
public class XN632085 extends AProcessor {
    private ILoanCsAO loanCsAO = SpringContextHolder.getBean(ILoanCsAO.class);

    private XN632085Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        LoanCs condition = new LoanCs();
        condition.setType(req.getType());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ILoanCsAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return loanCsAO.queryLoanCsPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632085Req.class);
        ObjValidater.validateReq(req);
    }

}
