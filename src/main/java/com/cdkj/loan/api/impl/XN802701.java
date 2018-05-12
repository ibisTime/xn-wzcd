package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IChargeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN802701Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 批量审批线下充值订单
 * @author: myb858 
 * @since: 2017年5月3日 上午9:24:44 
 * @history:
 */
public class XN802701 extends AProcessor {
    private IChargeAO chargeAO = SpringContextHolder.getBean(IChargeAO.class);

    private XN802701Req req = null;

    /** 
    * @see com.xnjr.base.api.IProcessor#doBusiness()
    */
    @Override
    public Object doBusiness() throws BizException {

        synchronized (XN802701.class) {
            for (String code : req.getCodeList()) {
                chargeAO.payOrder(code, req.getPayUser(), req.getPayResult(),
                    req.getPayNote());
            }
            return new BooleanRes(true);
        }

    }

    /** 
    * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
    */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802701Req.class);
        ObjValidater.validateReq(req);
    }
}
