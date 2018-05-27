package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBankAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632036Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详细查询银行信息
 * @author: silver 
 * @since: 2018年5月27日 下午5:39:49 
 * @history:
 */
public class XN632036 extends AProcessor {

    private IBankAO bankAO = SpringContextHolder.getBean(IBankAO.class);

    private XN632036Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return bankAO.getBank(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632036Req.class);
        ObjValidater.validateReq(req);
    }
}
