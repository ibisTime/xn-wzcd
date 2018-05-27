package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBankAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632032Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改银行
 * @author: silver 
 * @since: 2018年5月27日 下午5:21:06 
 * @history:
 */
public class XN632032 extends AProcessor {

    private IBankAO bankAO = SpringContextHolder.getBean(IBankAO.class);

    private XN632032Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        bankAO.editBank(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632032Req.class);
        ObjValidater.validateReq(req);
    }
}
