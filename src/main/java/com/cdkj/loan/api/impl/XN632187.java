package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IAdvanceFundAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.domain.AdvanceFund;
import com.cdkj.loan.dto.req.XN632187Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询垫资
 * @author: jiafr 
 * @since: 2018年6月17日 下午9:17:26 
 * @history:
 */

public class XN632187 extends AProcessor {

    private IAdvanceFundAO advanceFundAO = SpringContextHolder
        .getBean(IAdvanceFundAO.class);

    private XN632187Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        AdvanceFund condition = new AdvanceFund();
        condition.setBudgetCode(req.getBudgetCode());
        condition.setCustomerName(req.getCustomerName());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setLoanBankCode(req.getLoanBankCode());
        condition.setRoleCode(req.getRoleCode());
        condition.setApplyDatetimeStart(DateUtil.strToDate(
            req.getApplyDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setApplyDatetimeEnd(DateUtil.strToDate(
            req.getApplyDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IAdvanceFundAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());

        return advanceFundAO.queryAdvanceFundList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632187Req.class);
    }

}
