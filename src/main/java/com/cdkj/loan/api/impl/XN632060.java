package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarDealerAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632060Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增经销商管理
 * @author: CYL 
 * @since: 2018年5月26日 下午8:04:29 
 * @history:
 */
public class XN632060 extends AProcessor {

    private ICarDealerAO carDealerAO = SpringContextHolder
        .getBean(ICarDealerAO.class);

    private XN632060Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(carDealerAO.addCarDealer(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632060Req.class);
        ObjValidater.validateReq(req);
    }

}
