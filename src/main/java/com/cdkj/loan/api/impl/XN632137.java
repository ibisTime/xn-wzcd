package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISupplementReasonAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.SupplementReason;
import com.cdkj.loan.dto.req.XN632137Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 确认提交银行时的补件原因查询
 * @author: CYL 
 * @since: 2018年9月11日 下午8:49:27 
 * @history:
 */
public class XN632137 extends AProcessor {
    private ISupplementReasonAO supplementReasonAO = SpringContextHolder
        .getBean(ISupplementReasonAO.class);

    private XN632137Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SupplementReason condition = new SupplementReason();
        return supplementReasonAO.querySupplementReason(condition,
            req.getBudgetOrderCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632137Req.class);
        ObjValidater.validateReq(req);
    }

}
