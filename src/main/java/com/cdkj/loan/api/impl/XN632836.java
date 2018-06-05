package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IContractAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632836Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询合同
 * @author: jiafr 
 * @since: 2018年6月5日 下午9:56:50 
 * @history:
 */
public class XN632836 extends AProcessor {
    private IContractAO contractAO = SpringContextHolder
        .getBean(IContractAO.class);

    private XN632836Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return contractAO.getContract(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632836Req.class);
        ObjValidater.validateReq(req);
    }
}
