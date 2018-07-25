package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IContractImportAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632251Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 银行合同处理
 * @author: CYL 
 * @since: 2018年7月24日 下午9:20:09 
 * @history:
 */
public class XN632251 extends AProcessor {
    private IContractImportAO contractImportAO = SpringContextHolder
        .getBean(IContractImportAO.class);

    private XN632251Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        contractImportAO.handleContract(req.getCode(), req.getBudgetOrderCode(),
            req.getOperator());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632251Req.class);
        ObjValidater.validateReq(req);
    }

}
