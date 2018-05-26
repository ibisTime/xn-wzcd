package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IInsuranceCompanyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.InsuranceCompany;
import com.cdkj.loan.dto.req.XN632045Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查保险公司
 * @author: CYL 
 * @since: 2018年5月25日 下午4:55:45 
 * @history:
 */
public class XN632045 extends AProcessor {
    private IInsuranceCompanyAO insuranceCompanyAO = SpringContextHolder
        .getBean(IInsuranceCompanyAO.class);

    private XN632045Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        InsuranceCompany condition = new InsuranceCompany();
        condition.setKeyword(req.getKeyword());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IInsuranceCompanyAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return insuranceCompanyAO.queryInsuranceCompanyPage(start, limit,
            condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632045Req.class);
        ObjValidater.validateReq(req);
    }

}
