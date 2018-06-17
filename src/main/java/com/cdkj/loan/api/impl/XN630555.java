package com.cdkj.loan.api.impl;

import java.util.Date;

import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630555Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 拖车确认放款
 * @author: xieyj 
 * @since: 2018年6月17日 下午2:52:56 
 * @history:
 */
public class XN630555 extends AProcessor {
    private IRepayBizAO repayBizAO = SpringContextHolder
        .getBean(IRepayBizAO.class);

    private XN630555Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Date remitDatetime = DateUtil.strToDate(req.getRemitDatetime(),
            DateUtil.DATA_TIME_PATTERN_1);
        repayBizAO.takeCarSureFk(req.getCode(), req.getRemitBankCode(),
            req.getRemitBillPdf(), remitDatetime, req.getOperator());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630555Req.class);
        ObjValidater.validateReq(req);
    }

}
