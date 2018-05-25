package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInsuranceCompanyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632042Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改保险公司
 * @author: CYL 
 * @since: 2018年5月25日 下午4:34:56 
 * @history:
 */
public class XN632042 extends AProcessor {
    private IInsuranceCompanyAO insuranceCompanyAO = SpringContextHolder
        .getBean(IInsuranceCompanyAO.class);

    private XN632042Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        insuranceCompanyAO.editInsuranceCompany(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632042Req.class);
        ObjValidater.validateReq(req);
    }
}
