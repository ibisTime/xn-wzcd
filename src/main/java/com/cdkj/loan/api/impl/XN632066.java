package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarDealerAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632066Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 请款预算单详情
 * @author: CYL 
 * @since: 2018年5月24日 下午2:23:36 
 * @history:
 */
public class XN632066 extends AProcessor {
    private ICarDealerAO carDealerAO = SpringContextHolder
        .getBean(ICarDealerAO.class);

    private XN632066Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return carDealerAO.getCarDealer(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632066Req.class);
        ObjValidater.validateReq(req);
    }

}
