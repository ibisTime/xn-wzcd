package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630576Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 解除抵押-合同制作
 * @author: xieyj 
 * @since: 2018年6月30日 下午5:51:45 
 * @history:
 */
public class XN630576 extends AProcessor {
    private IRepayBizAO repayBizAO = SpringContextHolder
        .getBean(IRepayBizAO.class);

    private XN630576Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return repayBizAO.settleMortgagePrint(req.getCode(),
            req.getReleaseDatetime(), req.getReleaseTemplateId(),
            req.getReleaseNote(), req.getOperator());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630576Req.class);
        ObjValidater.validateReq(req);
    }

}
