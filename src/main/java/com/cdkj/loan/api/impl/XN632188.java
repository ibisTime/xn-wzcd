package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IAdvanceFundAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.AdvanceFund;
import com.cdkj.loan.dto.req.XN632188Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查询垫资
 * @author: jiafr 
 * @since: 2018年6月17日 下午8:02:51 
 * @history:
 */
public class XN632188 extends AProcessor {

    private IAdvanceFundAO advanceFundAO = SpringContextHolder
        .getBean(IAdvanceFundAO.class);

    private XN632188Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        AdvanceFund condition = new AdvanceFund();
        condition.setBudgetCode(req.getBudgetCode());
        condition.setCustomerName(req.getCustomerName());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setLoanBankCode(req.getLoanBankCode());
        condition.setApplyDatetimeStart(DateUtil.strToDate(
            req.getApplyDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setApplyDatetimeEnd(DateUtil.strToDate(
            req.getApplyDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IAdvanceFundAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return advanceFundAO.queryAdvanceFundPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632188Req.class);
        ObjValidater.validateReq(req);
    }
}
