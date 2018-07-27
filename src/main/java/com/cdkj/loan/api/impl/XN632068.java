package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarDealerAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632068Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 经销商协议到期预警
 * @author: jiafr 
 * @since: 2018年7月26日 下午7:16:53 
 * @history:
 */
public class XN632068 extends AProcessor {
    private ICarDealerAO carDealerAO = SpringContextHolder
        .getBean(ICarDealerAO.class);

    private XN632068Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        return carDealerAO.expireWarning(req.getYear(), req.getMonth());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632068Req.class);
        ObjValidater.validateReq(req);
    }
}
