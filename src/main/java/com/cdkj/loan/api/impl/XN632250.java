package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IContractImportAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632250Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 银行合同导入
 * @author: CYL 
 * @since: 2018年7月24日 下午1:13:35 
 * @history:
 */
public class XN632250 extends AProcessor {
    private IContractImportAO contractImportAO = SpringContextHolder
        .getBean(IContractImportAO.class);

    private XN632250Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        contractImportAO.importContract(req.getLoanBankCode(),
            req.getContractList(), req.getOperator());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632250Req.class);
        ObjValidater.validateReq(req);
    }

}
