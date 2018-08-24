package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630559Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 公司结清出纳打款
 * @author: CYL 
 * @since: 2018年8月24日 下午2:52:56 
 * @history:
 */
public class XN630559 extends AProcessor {
    private IRepayBizAO repayBizAO = SpringContextHolder
        .getBean(IRepayBizAO.class);

    private XN630559Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        repayBizAO.clearanceCashier(req.getCode(), req.getPaymentBank(),
            req.getPaymentPdf(), req.getOperator());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630559Req.class);
        ObjValidater.validateReq(req);
    }

}
