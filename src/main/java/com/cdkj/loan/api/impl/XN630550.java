package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN630550Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 清欠催收部审核
 * @author: silver 
 * @since: 2018年6月10日 上午10:49:05 
 * @history:
 */
public class XN630550 extends AProcessor {
    private IRepayBizAO repayBizAO = SpringContextHolder
        .getBean(IRepayBizAO.class);

    private XN630550Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        repayBizAO.approveByQkcsDepartment(req.getCode(),
            StringValidater.toLong(req.getCutLyDeposit()), req.getOperator(),
            req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630550Req.class);
        ObjValidater.validateReq(req);
    }

}
