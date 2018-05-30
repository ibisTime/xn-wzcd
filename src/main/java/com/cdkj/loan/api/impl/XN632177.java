package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IGpsAO;
import com.cdkj.loan.ao.ILoanProductAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.LoanProduct;
import com.cdkj.loan.dto.req.XN632177Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询贷款产品
 * @author: silver 
 * @since: 2018年5月30日 下午1:47:16 
 * @history:
 */
public class XN632177 extends AProcessor {
    private ILoanProductAO loanProduct = SpringContextHolder
        .getBean(ILoanProductAO.class);

    private XN632177Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        LoanProduct condition = new LoanProduct();
        condition.setName(req.getName());
        condition.setLoanBank(req.getLoanBank());
        condition.setStatus(req.getStatus());

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IGpsAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        return loanProduct.queryLoanProductList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632177Req.class);
        ObjValidater.validateReq(req);
    }
}
