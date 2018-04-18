package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IMarketAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN625290Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * Created by tianlei on 2017/十一月/13.
 */
public class XN625290 extends AProcessor {

    private IMarketAO marketAO = SpringContextHolder
            .getBean(IMarketAO.class);

    private XN625290Req req;

    @Override
    public Object doBusiness() throws BizException {

        throw new BizException("xn000","如需获取处理好的价格 请调用 625292");
//        return  this.marketAO.marketByCoin(req.getCoinList());

    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {

        req = JsonUtil.json2Bean(inputparams,XN625290Req.class);
        ObjValidater.validateReq(req);

    }
}
