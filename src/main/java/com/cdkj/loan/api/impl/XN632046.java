package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInsuranceCompanyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.InsuranceCompany;
import com.cdkj.loan.dto.req.XN632046Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查保险公司
 * @author: CYL 
 * @since: 2018年5月25日 下午4:55:45 
 * @history:
 */
public class XN632046 extends AProcessor {
    private IInsuranceCompanyAO insuranceCompanyAO = SpringContextHolder
        .getBean(IInsuranceCompanyAO.class);

    private XN632046Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        InsuranceCompany condition = new InsuranceCompany();
        condition.setKeyword(req.getKeyword());
        return insuranceCompanyAO.queryInsuranceCompanyList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632046Req.class);
        ObjValidater.validateReq(req);
    }

}
