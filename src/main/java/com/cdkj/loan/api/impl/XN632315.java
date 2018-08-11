package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IBankRepointAO;
import com.cdkj.loan.ao.ISYSRoleAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BankRepoint;
import com.cdkj.loan.dto.req.XN632315Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询返点支付
 * @author: jiafr 
 * @since: 2018年8月11日 下午2:53:55 
 * @history:
 */
public class XN632315 extends AProcessor {

    private IBankRepointAO bankRepointAO = SpringContextHolder
        .getBean(IBankRepointAO.class);

    private XN632315Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BankRepoint condition = new BankRepoint();
        condition.setLoanBankCode(req.getLoanBankCode());
        condition.setCarDealerCode(req.getCarDealerCode());
        condition.setCurNodeCode(req.getCurNodeCode());
        condition.setCustomerName(req.getCustomerName());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = ISYSRoleAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return bankRepointAO.queryBankRepointPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632315Req.class);
        ObjValidater.validateReq(req);
    }
}
