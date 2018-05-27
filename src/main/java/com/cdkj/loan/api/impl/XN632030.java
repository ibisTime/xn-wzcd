package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBankAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632030Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增银行
 * @author: silver 
 * @since: 2018年5月27日 下午5:21:06 
 * @history:
 */
public class XN632030 extends AProcessor {

    private IBankAO bankAO = SpringContextHolder.getBean(IBankAO.class);

    private XN632030Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(bankAO.addBank(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632030Req.class);
        ObjValidater.validateReq(req);
    }
}
