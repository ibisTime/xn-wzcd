package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInsuranceCompanyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632040Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增保险公司
 * @author: CYL 
 * @since: 2018年5月25日 下午4:22:37 
 * @history:
 */
public class XN632040 extends AProcessor {

    private IInsuranceCompanyAO insuranceCompanyAO = SpringContextHolder
        .getBean(IInsuranceCompanyAO.class);

    private XN632040Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(insuranceCompanyAO.addInsuranceCompany(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632040Req.class);
        ObjValidater.validateReq(req);
    }

}
