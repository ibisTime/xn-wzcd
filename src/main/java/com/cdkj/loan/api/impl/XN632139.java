package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632139Req;
import com.cdkj.loan.dto.res.XN632139Res;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 查询还款日、账单日
 * @author: CYL 
 * @since: 2018年8月23日 下午2:22:42 
 * @history:
 */
public class XN632139 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632139Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        XN632139Res res = budgetOrderAO.selectData(req.getCode());
        return res;
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632139Req.class);
        ObjValidater.validateReq(req);
    }

}
