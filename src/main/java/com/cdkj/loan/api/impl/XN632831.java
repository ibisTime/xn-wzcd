package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IContractAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632831Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 删除合同
 * @author: jiafr 
 * @since: 2018年6月5日 下午8:51:56 
 * @history:
 */
public class XN632831 extends AProcessor {
    private IContractAO contractAO = SpringContextHolder
        .getBean(IContractAO.class);

    private XN632831Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        contractAO.dropContract(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632831Req.class);
        ObjValidater.validateReq(req);
    }
}
