package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IChargeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN802707Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询充值订单对账信息
 * @author: xieyj 
 * @since: 2017年5月13日 下午7:58:10 
 * @history:
 */
public class XN802707 extends AProcessor {
    private IChargeAO chargeAO = SpringContextHolder.getBean(IChargeAO.class);

    private XN802707Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return chargeAO.getChargeCheckInfo(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802707Req.class);
        ObjValidater.validateReq(req);
    }

}
