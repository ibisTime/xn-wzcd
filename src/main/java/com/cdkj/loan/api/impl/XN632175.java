package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ILoanProductAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.LoanProduct;
import com.cdkj.loan.dto.req.XN632175Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询贷款产品
 * @author: silver 
 * @since: 2018年5月30日 下午1:33:40 
 * @history:
 */
public class XN632175 extends AProcessor {
    private ILoanProductAO loanProduct = SpringContextHolder
        .getBean(ILoanProductAO.class);

    private XN632175Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        LoanProduct condition = new LoanProduct();
        condition.setName(req.getName());
        condition.setLoanBank(req.getLoanBank());
        condition.setStatus(req.getStatus());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ILoanProductAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return loanProduct.queryLoanProductPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632175Req.class);
        ObjValidater.validateReq(req);
    }

}
