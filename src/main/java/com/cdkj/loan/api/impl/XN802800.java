package com.cdkj.loan.api.impl;

import java.math.BigDecimal;

import com.cdkj.loan.ao.IJourAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN802800Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 人工对账
 * @author: xieyj 
 * @since: 2016年12月25日 下午3:48:54 
 * @history:
 */
public class XN802800 extends AProcessor {
    private IJourAO jourAO = SpringContextHolder.getBean(IJourAO.class);

    private XN802800Req req = null;

    @Override
    public synchronized Object doBusiness() throws BizException {
        BigDecimal checkAmount = StringValidater
            .toBigDecimal(req.getCheckAmount());
        jourAO.checkJour(req.getCode(), checkAmount, req.getCheckUser(),
            req.getCheckNote(), req.getSystemCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802800Req.class);
        StringValidater.validateBlank(req.getCode(), req.getCheckNote(),
            req.getCheckUser(), req.getSystemCode());
        ObjValidater.validateReq(req);
    }
}
