package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IBankAO;
import com.cdkj.loan.ao.IBankSubbranchAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BankSubbranch;
import com.cdkj.loan.dto.req.XN632055Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询支行
 * @author: silver 
 * @since: 2018年5月28日 上午11:09:16 
 * @history:
 */
public class XN632055 extends AProcessor {

    private IBankSubbranchAO bankSubbranchAO = SpringContextHolder
        .getBean(IBankSubbranchAO.class);

    private XN632055Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BankSubbranch condition = new BankSubbranch();
        condition.setBankCode(req.getBankCode());
        condition.setAbbrName(req.getAbbrName());
        condition.setOpenBank(req.getOpenBank());
        condition.setPhoneNumber(req.getPhoneNumber());
        condition.setPostCode(req.getPostCode());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBankAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return bankSubbranchAO.queryBankSubbranchPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632055Req.class);
        ObjValidater.validateReq(req);
    }

}
