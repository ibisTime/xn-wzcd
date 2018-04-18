package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ITradeOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 
 * @author: haiqingzheng 
 * @since: 2017年12月15日 下午12:59:19 
 * @history:
 */
public class XN625259 extends AProcessor {

    private ITradeOrderAO tradeOrderAO = SpringContextHolder
        .getBean(ITradeOrderAO.class);

    @Override
    public Object doBusiness() throws BizException {

        tradeOrderAO.createGroupIfNotExist();
        return new BooleanRes(true);

    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {

    }
}
