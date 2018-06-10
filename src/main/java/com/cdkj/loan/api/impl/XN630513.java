package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630513Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 产品确认结清
 * @author: xieyj 
 * @since: 2018年6月7日 下午5:39:47 
 * @history:
 */
public class XN630513 extends AProcessor {
    private IRepayBizAO repaybizAO = SpringContextHolder
        .getBean(IRepayBizAO.class);

    private XN630513Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        repaybizAO.confirmSettledProduct(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630513Req.class);
        ObjValidater.validateReq(req);
    }

}
