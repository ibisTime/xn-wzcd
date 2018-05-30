package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632126Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查GPS安装列表
 * @author: CYL 
 * @since: 2018年5月30日 下午2:40:12 
 * @history:
 */
public class XN632126Gps extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632126Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        budgetOrderAO.advancefund(req.getCode(), req.getOperator(),
            req.getGpsAzList());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632126Req.class);
        ObjValidater.validateReq(req);
    }

}
