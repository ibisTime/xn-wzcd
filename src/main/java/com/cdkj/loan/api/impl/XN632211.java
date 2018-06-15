package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632211Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 制卡录入
 * @author: CYL 
 * @since: 2018年6月15日 下午8:17:36 
 * @history:
 */
public class XN632211 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632211Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        budgetOrderAO.refreshCardMaking(req.getCode(), req.getBankCardNumber(),
            req.getMakeCardRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632211Req.class);
        ObjValidater.validateReq(req);
    }

}
