package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.IMarketAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.ObjValidater;
import com.cdkj.coin.dto.req.XN625290Req;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

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
