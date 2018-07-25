package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IContractImportAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632256Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 银行合同导入详情查
 * @author: CYL 
 * @since: 2018年7月25日 上午10:29:41 
 * @history:
 */
public class XN632256 extends AProcessor {
    private IContractImportAO contractImportAO = SpringContextHolder
        .getBean(IContractImportAO.class);

    private XN632256Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return contractImportAO.getContractImport(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632256Req.class);
        ObjValidater.validateReq(req);
    }

}
