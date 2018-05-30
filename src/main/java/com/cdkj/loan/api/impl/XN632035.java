package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IBankAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.dto.req.XN632035Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询银行
 * @author: silver 
 * @since: 2018年5月27日 下午5:32:46 
 * @history:
 */
public class XN632035 extends AProcessor {

    private IBankAO bankAO = SpringContextHolder.getBean(IBankAO.class);

    private XN632035Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Bank condition = new Bank();
        condition.setBankCode(req.getBankCode());
        condition.setBankName(req.getBankName());
        condition.setSubbranch(req.getSubbranch());
        condition.setStatus(req.getStatus());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBankAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return bankAO.queryBankPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632035Req.class);
        ObjValidater.validateReq(req);
    }

}
