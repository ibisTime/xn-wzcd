package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632111Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;

/**
 * 录入银行征信结果
 * @author: jiafr 
 * @since: 2018年5月25日 下午3:22:27 
 * @history:
 */
public class XN632111 extends AProcessor {

    private ICreditUserAO creditUserAO;

    private XN632111Req req = null;;

    @Override
    public Object doBusiness() throws BizException {

        creditUserAO.inputBankCreditResult(req);

        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632111Req.class);
        ObjValidater.validateReq(req);

    }

}
