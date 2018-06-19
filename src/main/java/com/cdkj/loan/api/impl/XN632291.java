package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarDealerProtocolAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632291Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 协议收费
 * @author: jiafr 
 * @since: 2018年6月16日 下午5:18:15 
 * @history:
 */
public class XN632291 extends AProcessor {
    private ICarDealerProtocolAO carDealerProtocolAO = SpringContextHolder
        .getBean(ICarDealerProtocolAO.class);

    private XN632291Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return carDealerProtocolAO.calProtocolFee(req.getBudgetOrderCode(),
            req.getCarDealerCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632291Req.class);
        ObjValidater.validateReq(req);
    }
}
