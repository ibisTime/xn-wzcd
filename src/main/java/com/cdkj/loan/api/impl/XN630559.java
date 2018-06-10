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
 * 司法诉讼结果录入
 * @author: CYL 
 * @since: 2018年6月10日 下午4:11:27 
 * @history:
 */
public class XN630559 extends AProcessor {
    private IRepayBizAO repayBizAO = SpringContextHolder
        .getBean(IRepayBizAO.class);

    private XN630559Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        repayBizAO.judicialLitigationEntry(req.getCode(), req.getBuyOutAmount(),
            req.getWay(), req.getOperator());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630559Req.class);
        ObjValidater.validateReq(req);
    }

}
