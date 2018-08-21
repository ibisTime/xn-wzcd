package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IPerformanceBondAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632902Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 打印收据
 * @author: CYL 
 * @since: 2018年8月21日 下午7:41:22 
 * @history:
 */
public class XN632902 extends AProcessor {
    private IPerformanceBondAO performanceBondAO = SpringContextHolder
        .getBean(IPerformanceBondAO.class);

    private XN632902Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        performanceBondAO.editPerformanceBond(req.getBudgetCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632902Req.class);
        ObjValidater.validateReq(req);
    }
}
