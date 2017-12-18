package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.ITradeOrderAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.dto.res.BooleanRes;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

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
    public void doCheck(String inputparams) throws ParaException {

    }
}
