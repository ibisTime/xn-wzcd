package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ILoanProductAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632176Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详细查询贷款产品
 * @author: silver 
 * @since: 2018年5月30日 下午1:33:40 
 * @history:
 */
public class XN632176 extends AProcessor {
    private ILoanProductAO loanProduct = SpringContextHolder
        .getBean(ILoanProductAO.class);

    private XN632176Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return loanProduct.getLoanProduct(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632176Req.class);
        ObjValidater.validateReq(req);
    }

}
