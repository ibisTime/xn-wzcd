package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAccountAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN802502Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 账户详情
 * @author: xieyj 
 * @since: 2016年12月23日 下午8:36:10 
 * @history:
 */
public class XN802502 extends AProcessor {

    private IAccountAO accountAO = SpringContextHolder
        .getBean(IAccountAO.class);

    private XN802502Req req = null;

    /** 
    * @see com.xnjr.base.api.IProcessor#doBusiness()
    */
    @Override
    public Object doBusiness() throws BizException {
        return accountAO.getAccount(req.getAccountNumber());
    }

    /** 
    * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
    */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802502Req.class);
        ObjValidater.validateReq(req);
    }
}
